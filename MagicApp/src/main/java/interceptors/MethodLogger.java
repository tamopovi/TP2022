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
        System.out.println("Sending BI event for" + context.getTarget().getClass().getSimpleName() + "...");
        return context.proceed();
    }
}