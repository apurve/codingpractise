package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FinonacciTest {

    private int n;

    @Before
    public void initialize() {
        n = 4;
    }

    @Test
    public void testFindMaximumNumber() {
        Assert.assertEquals(3, Fibonacci.calc_fib(n));
    }
}
