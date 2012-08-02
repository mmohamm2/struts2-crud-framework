package com.dakuupa.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
/**
 * Based on code at http://struts.apache.org/2.0.14/docs/https-and-ie-issues.html
 * This interceptor sets the the HTTP Header to work around IE SSL weirdness  *
 * @author Eric Molitor <a href="mailto:eric@tuxbot.com">eric@tuxbot.com</a>
 * @version 1.0
 */
public class InternetExplorerHTTPSInterceptor extends AroundInterceptor {

    protected void after(ActionInvocation actionInvocation, String string) throws Exception {
        // Nothing
    }

    protected void before(ActionInvocation actionInvocation) throws Exception {
        HttpServletResponse response = (HttpServletResponse) actionInvocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control","private");
    }
    
}