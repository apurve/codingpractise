package leave.nucleus.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeCRUDAspect {

    /*@Before("execution(* EmployeeManager.getEmployeeById(..))")
    public void logBeforeV1(JoinPoint joinPoint)
    {
        System.out.println("EmployeeCRUDAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
    }*/

    @AfterThrowing(pointcut="execution(public * leave.nucleus.spring.EmployeeManager.invoke(..))", throwing= "exception")
    public void logBeforeDelete(JoinPoint joinPoint, Exception exception) throws Throwable {
        System.out.println("EmployeeCRUDAspect.logBeforeDelete() : " + joinPoint.getSignature().getName());
        System.out.println("Getting exception : " + exception.getClass().getCanonicalName());
    }

    /*@Before("execution(public * leave.nucleus.spring.EmployeeManager.invoke(..))")
    public void logBeforeV2(JoinPoint joinPoint)
    {
        System.out.println("EmployeeCRUDAspect.logBeforeV2() : " + joinPoint.getSignature().getName());
    }*/

    /*@After("execution(* EmployeeManager.getEmployeeById(..))")
    public void logAfterV1(JoinPoint joinPoint)
    {
        System.out.println("EmployeeCRUDAspect.logAfterV1() : " + joinPoint.getSignature().getName());
    }*/

    /*@After("execution(* EmployeeManager.*(..))")
    public void logAfterV2(JoinPoint joinPoint)
    {
        System.out.println("EmployeeCRUDAspect.logAfterV2() : " + joinPoint.getSignature().getName());
    }*/

}