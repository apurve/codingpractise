package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void testGoldBarsKnapsack() {
        int[] goldBars = {1,4,8};
        Assert.assertEquals(9, Knapsack.optimalWeight(10, goldBars));
    }

}