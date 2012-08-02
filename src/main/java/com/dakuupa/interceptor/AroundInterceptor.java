package com.dakuupa.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * An abstract interceptor that provides simple access to before/after callouts.
 * from OpenSymphony XWork
 */
public abstract class AroundInterceptor implements Interceptor {

    public void destroy() {
    }

    public void init() {
    }

    public String intercept(ActionInvocation invocation) throws Exception {
        String result = null;

        before(invocation);
        result = invocation.invoke();
        after(invocation, result);
        return result;
    }

    protected abstract void after(ActionInvocation dispatcher, String result) throws Exception;

    protected abstract void before(ActionInvocation invocation) throws Exception;

}

