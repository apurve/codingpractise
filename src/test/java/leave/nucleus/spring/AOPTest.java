package leave.nucleus.spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {

    ApplicationContext context = null;

    @Before
    public void initializeSpringContext() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test(expected = NullPointerException.class)
    public void testInterceptingAnotherAdvice() throws Throwable {
        MyInterceptor manager = context.getBean(EmployeeManager.class);
        manager.invoke(null);
        //manager.create(new EmployeeDTO());
    }

}