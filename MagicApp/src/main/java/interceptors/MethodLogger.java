package interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class MethodLogger implements Serializable{
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        System.out.println(context.getMethod().getName() + " CALLED!");
        String loggedMethodName = context.getMethod().getName();
        if(loggedMethodName.equals("createCard")) {
            System.out.println("Sending BI event that the user has created a card");
            // sending card created event...
        }
        if(loggedMethodName.equals("createSet")) {
            System.out.println("Sending BI event that the user has created a set");
            // sending set created event...
        }
        return context.proceed();
    }
}