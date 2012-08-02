package com.dakuupa.struts.crud;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author etwilliams
 * 
 * Abstract class for dealing with Users
 * @param <A> the action class. Must extend CrudAction
 * @param <M> the model class. Must extend CrudModel
 *  -sets username in model.getUser()
 *  -gets instances of action and model
 *  -can check if URI contains string (i.e.: see what page user is on)
 */
public abstract class AbstractUserInterceptor<A extends CrudAction, M extends CrudModel> implements Interceptor {

    protected Logger logger = Logger.getLogger(getClass().getName());
    protected A action;
    protected M model;
    protected HttpServletRequest request;
    public static final String ACCESS_ERROR = "accesserror";
    public static final String PATH_ADMIN = "admin";
    public static final String PATH_SECURE = "secure";
    public static final String PATH_MOBILE = "mobile";

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        prepare(invocation);
        return doIntercept(invocation);
    }

    public final void prepare(ActionInvocation invocation) {
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        action = (A) invocation.getAction();
        model = (M) action.getModel();

        if (request.getUserPrincipal() != null && request.getUserPrincipal().getName() != null) {
            model.getUser().setUsername(request.getUserPrincipal().getName().toLowerCase());
        }
    }

    public abstract String doIntercept(ActionInvocation invocation) throws Exception;
    
    public boolean checkPathForString(String searchStr){
        if (request.getRequestURI().contains(searchStr)) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {
        //do nothing
    }

    @Override
    public void init() {
        //do nothing
    }
}
