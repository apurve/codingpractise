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
        Assert.assertEquals(3, PrimitiveCalculator.optimal_sequence(5).size()-1);
    }

}