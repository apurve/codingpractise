package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimitiveCalculatorTest {

    @Test
    public void testPrimitiveCalculatorForLessThanMinimumDividend() {
        Assert.assertEquals(0, PrimitiveCalculator.optimal_sequence(0).size()-1);
    }

    @Test
    public void testPrimitiveCalculatorForMinimumDividend() {
        Assert.assertEquals(0, PrimitiveCalculator.optimal_sequence(1).size()-1);
    }

    @Test
    public void testPrimitiveCalculatorDividendBetweenMaximumAndMinimum() {
        Assert.assertEquals(1, PrimitiveCalculator.optimal_sequence(2).size()-1);
    }

    @Test
    public void testPrimitiveCalculatorForMaximumDividend() {
        Assert.assertEquals(1, PrimitiveCalculator.optimal_sequence(3).size()-1);
    }

    @Test
    public void testPrimitiveCalculatorForMoreThanMaximumDividend() {
        Assert.assertEquals(14, PrimitiveCalculator.optimal_sequence(96234).size()-1);
        /*
        Your output:
        15
        0 1 2 4 5 10 11 22 66 198 594 1782 5346 16038 16039 32078
        Correct output:
        14
        1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
         (Time used: 0.38/2.25, memory used: 26341376/536870912.)
 */
    }

}