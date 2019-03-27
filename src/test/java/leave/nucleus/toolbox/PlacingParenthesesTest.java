package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Test;

public class PlacingParenthesesTest {

    @Test
    public void testPlacingParentheses() {
        Assert.assertEquals(6, PlacingParentheses.getMaximValue("1+5"));
    }

    @Test
    public void testPlacingParenthesesSecond() {
        Assert.assertEquals(200, PlacingParentheses.getMaximValue("5-8+7*4-8+9"));
    }

    @Test
    public void testMaximum() {
        int [] maximum = {5,6,6,1,7,4};
        Assert.assertEquals(7, PlacingParentheses.maximum(maximum));
    }

    @Test
    public void testMinimum() {
        int [] minimum = {5,6,6,1,7,4};
        Assert.assertEquals(1, PlacingParentheses.minimum(minimum));
    }

}