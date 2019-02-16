package leave.nucleus.spring;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager extends Manager implements MyInterceptor {

    public EmployeeDTO getEmployeeById(Integer employeeId) throws Throwable {
        System.out.println("Method getEmployeeById() called");
        return new EmployeeDTO();
    }

    public List<EmployeeDTO> getAllEmployee() {
        System.out.println("Method getAllEmployee() called");
        return new ArrayList<EmployeeDTO>();
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("MethodInterceptor invoke() called");
        delete(1);
        return null;
    }

}