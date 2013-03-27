package com.dakuupa.struts.crud;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.security.Principal;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author etwilliams
 */
public abstract class CrudAction<T extends CrudModel> extends ActionSupport implements SessionAware, ServletRequestAware, ModelDriven<T> {

    protected HttpServletRequest request;
    protected T model;
    protected Map session;
    protected Logger logger = Logger.getLogger(getClass().getName());
    /*
     * Action types
     */
    public static final String LIST_ACTION = "list";
    public static final String CREATE_ACTION = "create";
    public static final String UPDATE_ACTION = "update";
    public static final String DELETE_ACTION = "delete";
    public static final String RELOAD_ACTION = "reload";
    public static final String CREATE_RELOAD_ACTION = "createreload";
    public static final String UPDATE_RELOAD_ACTION = "updatereload";

    @Override
    /*
     * Overrides struts2 ActionSupport.execute() method
     */
    public String execute() throws Exception {
        populateUsername();
        preAction();
        String returnValue = doAction();
        postAction(returnValue);
        return returnValue;
    }

    /*
     * get user principal information and add to BaseModel
     */
    private void populateUsername() {
        Principal principal = request.getUserPrincipal();
        if (principal != null && principal.getName() != null) {
            model.getUser().setUsername(principal.getName().toLowerCase());
        }
    }

    /*
     * Override to bypass processForm
     */
    protected String doAction() {
        if (model.isRequirePermission() && model.getUser().isAllowAccess()) {
            return processForm();
        } else if (!model.isRequirePermission()) {
            return processForm();
        } else {
            addWarningMessage("You do not have access to this function");
            return ERROR;
        }
    }

    /*
     * Called before doAction
     */
    protected void preAction() {
        //override as needed
    }

    /*
     * Called after doAction
     */
    protected void postAction(String returnValue) {
        //override as needed
    }

    /*
     * Process CRUD forms (default method)
     */
    protected String processForm() {
        if (model.getAction() != null && !model.getAction().equals("")) {

            if (model.getAction().equals(LIST_ACTION)) {
                try {
                    list();
                    return model.getForwardToListResult();
                } catch (Exception e) {
                    addErrorMessage("Error listing " + model.getModelDisplayName() + " items");
                    logger.log(Level.SEVERE, e.getMessage());
                    return ERROR;
                }
            } else if (model.getAction().equals(CREATE_RELOAD_ACTION)) {
                createReload();
                model.setAction(CREATE_ACTION);
                return SUCCESS;
            } else if (model.getAction().equals(UPDATE_RELOAD_ACTION)) {
                updateReload();
                model.setAction(UPDATE_ACTION);
                return SUCCESS;
            } else if (model.getAction().equals(CREATE_ACTION)) {
                try {
                    if (validateForm()) {
                        int id = create();
                        model.setId(id);
                        addSuccessMessage("Added " + model.getModelDisplayName());
                        read();
                        model.setAction(UPDATE_ACTION);
                        if (model.isReturnToListOnAdd()) {
                            list();
                            model.setAction(LIST_ACTION);
                            return model.getForwardToListResult();
                        } else {
                            return SUCCESS;
                        }
                    } else {
                        return ERROR;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    addErrorMessage("Error adding " + model.getModelDisplayName());
                    logger.log(Level.SEVERE, e.getMessage());
                    return ERROR;
                }
            } else if (model.getAction().equals(UPDATE_ACTION)) {
                try {
                    if (validateForm()) {
                        update();
                        read();
                        model.setAction(UPDATE_ACTION);
                        addSuccessMessage("Updated " + model.getModelDisplayName());
                        
                        if (model.isReturnToListOnUpdate()) {
                            list();
                            model.setAction(LIST_ACTION);
                            return model.getForwardToListResult();
                        } else {
                            return SUCCESS;
                        }
                        
                    } else {
                        return ERROR;
                    }
                } catch (Exception e) {
                    addErrorMessage("Error updating " + model.getModelDisplayName());
                    logger.log(Level.SEVERE, e.getMessage());
                    return ERROR;
                }
            } else if (model.getAction().equals(DELETE_ACTION) && model.getId() != -1) {
                try {
                    if (delete()) {
                        addSuccessMessage("Removed " + model.getModelDisplayName());
                        model.setAction(LIST_ACTION);
                        list();
                        return model.getForwardToListResult();
                    } else {
                        read();
                        return ERROR;
                    }
                } catch (Exception e) {
                    addErrorMessage("Error removing " + model.getModelDisplayName());
                    logger.log(Level.SEVERE, e.getMessage());
                    return ERROR;
                }
            } else {
                return ERROR;
            }
        } else {
            if (model.getId() != -1) {
                //reading existing
                read();
                model.setAction(UPDATE_ACTION);
            } else {
                //adding new
                model.setAction(CREATE_ACTION);
            }
            return SUCCESS;
        }
    }

    protected abstract int create();

    protected abstract void read();

    protected abstract void update();

    protected abstract boolean delete();

    protected void list() {
        //override as needed
    }

    //used when page is reloaded when adding a new item
    protected void createReload() {
        //override as needed
    }

    //used when page is reloaded when editing a new item
    protected void updateReload() {
        //override as needed
    }

    //override to add validation
    protected boolean validateForm() {
        return true;
    }

    public final void addHelpMessage(String msg) {
        model.getHelpMessages().add(msg);
    }

    public final void addSuccessMessage(String msg) {
        model.getSuccessMessages().add(msg);
    }

    public final void addInfoMessage(String msg) {
        model.getInfoMessages().add(msg);
    }

    public final void addWarningMessage(String msg) {
        model.getWarningMessages().add(msg);
    }

    public final void addErrorMessage(String msg) {
        model.getErrorMessages().add(msg);
    }

    @Override
    public void setServletRequest(HttpServletRequest req) {
        this.request = req;
    }

    @Override
    public T getModel() {
        return model;
    }

    public Map getSession() {
        return session;
    }

    @Override
    public void setSession(final Map<String,Object> session) {
        this.session = session;
    }
}
