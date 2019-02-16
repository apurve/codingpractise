package leave.nucleus.spring;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;

@FunctionalInterface
public interface MyInterceptor {
    Object invoke(MethodInvocation var1) throws Throwable;
}
