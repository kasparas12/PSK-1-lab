package vu.mif.interceptors;
import vu.mif.interfaces.Logger;

import javax.ejb.DependsOn;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Transactional;
import java.io.Serializable;

@Interceptor
@AuditedRequest
@DependsOn("entityManagerFactory")
public class RequestAuditor implements Serializable{

    @Inject
    private Logger logger;

    @Transactional
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {

        logger.makeAuditLog(context);
        return context.proceed();
    }
}