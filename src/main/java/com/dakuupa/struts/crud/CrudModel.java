package com.dakuupa.struts.crud;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author etwilliams
 */
public class CrudModel {

    @XmlTransient
    protected Integer id = -1;
    //action to call (for processForm method)
    @XmlTransient
    protected String action;
    @XmlTransient
    protected User user = new User();
    @XmlTransient
    protected String modelDisplayName;
    @XmlTransient
    protected String forwardToListResult;
    @XmlTransient
    protected boolean requirePermission = false;
    @XmlTransient
    protected boolean returnToListOnAdd = false;
    @XmlTransient
    protected boolean returnToListOnUpdate = false;
    //item list
    @XmlTransient
    protected List modelList = new ArrayList();
    //Messages
    @XmlTransient
    private List<String> helpMessages = new ArrayList<String>();
    @XmlTransient
    private List<String> successMessages = new ArrayList<String>();
    @XmlTransient
    private List<String> infoMessages = new ArrayList<String>();
    @XmlTransient
    private List<String> warningMessages = new ArrayList<String>();
    @XmlTransient
    private List<String> errorMessages = new ArrayList<String>();

    public CrudModel() {
    }

    public CrudModel(String modelDisplayName, String forwardToListResult, boolean requirePermission, boolean returnToListOnAdd) {
        this.modelDisplayName = modelDisplayName;
        this.forwardToListResult = forwardToListResult;
        this.requirePermission = requirePermission;
        this.returnToListOnAdd = returnToListOnAdd;
    }

    public CrudModel(String modelDisplayName, String forwardToListResult, boolean requirePermission, boolean returnToListOnAdd, boolean returnToListOnUpdate) {
        this.modelDisplayName = modelDisplayName;
        this.forwardToListResult = forwardToListResult;
        this.requirePermission = requirePermission;
        this.returnToListOnAdd = returnToListOnAdd;
        this.returnToListOnUpdate = returnToListOnUpdate;
    }

    @XmlTransient
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public String getModelDisplayName() {
        return modelDisplayName;
    }

    public void setModelDisplayName(String modelDisplayName) {
        this.modelDisplayName = modelDisplayName;
    }

    @XmlTransient
    public String getForwardToListResult() {
        return forwardToListResult;
    }

    public void setForwardToListResult(String forwardToListResult) {
        this.forwardToListResult = forwardToListResult;
    }

    @XmlTransient
    public boolean isReturnToListOnAdd() {
        return returnToListOnAdd;
    }

    public void setReturnToListOnAdd(boolean returnToListOnAdd) {
        this.returnToListOnAdd = returnToListOnAdd;
    }

    @XmlTransient
    public List getModelList() {
        return modelList;
    }

    public boolean isRequirePermission() {
        return requirePermission;
    }

    public void setModelList(List modelList) {
        this.modelList = modelList;
    }

    @XmlTransient
    public User getUser() {
        return user;
    }

    @XmlTransient
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @XmlTransient
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    @XmlTransient
    public List<String> getHelpMessages() {
        return helpMessages;
    }

    @XmlTransient
    public List<String> getInfoMessages() {
        return infoMessages;
    }

    @XmlTransient
    public List<String> getSuccessMessages() {
        return successMessages;
    }

    @XmlTransient
    public List<String> getWarningMessages() {
        return warningMessages;
    }

    public boolean isReturnToListOnUpdate() {
        return returnToListOnUpdate;
    }

    public void setReturnToListOnUpdate(boolean returnToListOnUpdate) {
        this.returnToListOnUpdate = returnToListOnUpdate;
    }
}
