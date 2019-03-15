package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PrimitiveCalculatorTest {

    @Test
    public void testPrimitiveCalculatorForLessThanMinimumDividend() {
        List<Integer> sequence = PrimitiveCalculator.optimal_sequence(0);
        Assert.assertEquals(-1, sequence.size()-1);
        Assert.assertEquals("", getStringRepresentation(sequence));
    }

    @Test
    public void testPrimitiveCalculatorForMinimumDividend() {
        List<Integer> sequence = PrimitiveCalculator.optimal_sequence(1);
        Assert.assertEquals(0, sequence.size()-1);
        Assert.assertEquals("1", getStringRepresentation(sequence));
    }

    @Test
    public void testPrimitiveCalculatorDividendBetweenMaximumAndMinimum() {
        List<Integer> sequence = PrimitiveCalculator.optimal_sequence(2);
        Assert.assertEquals(1, sequence.size()-1);
        Assert.assertEquals("1 2", getStringRepresentation(sequence));
    }

    @Test
    public void testPrimitiveCalculatorForMaximumDividend() {
        List<Integer> sequence = PrimitiveCalculator.optimal_sequence(3);
        Assert.assertEquals(1, sequence.size()-1);
        Assert.assertEquals("1 3", getStringRepresentation(sequence));
    }

    /*
        Your output:
        15
        0 1 2 4 5 10 11 22 66 198 594 1782 5346 16038 16039 32078
        Correct output:
        14
        1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234
         (Time used: 0.38/2.25, memory used: 26341376/536870912.)
    */
    @Test
    public void testPrimitiveCalculatorForMoreThanMaximumDividend() {
        List<Integer> sequence = PrimitiveCalculator.optimal_sequence(11);
        Assert.assertEquals(4, sequence.size()-1);
        Assert.assertEquals("1 3 9 10 11", getStringRepresentation(sequence));
    }

    private String getStringRepresentation(List<Integer> sequence) {
        StringBuilder sequenceString = new StringBuilder();
        for (Integer x : sequence) {
            sequenceString.append(x + " ");
        }
        return sequenceString.toString().trim();
    }

}
