package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeDPTest {

    @Test
    public void testCountOfChangeForLessThanMinimimDenomiation() {
        Assert.assertEquals(0, ChangeDP.getCountOfChange(0, ChangeDP.denominationsSorted));
    }

    @Test
    public void testCountOfChangeForMinimimDenomiation() {
        Assert.assertEquals(1, ChangeDP.getCountOfChange(1, ChangeDP.denominationsSorted));
    }

    @Test
    public void testCountOfChangeForDenomiationBetweenMaximumAndMinimum() {
        Assert.assertEquals(2, ChangeDP.getCountOfChange(2, ChangeDP.denominationsSorted));
    }

    @Test
    public void testCountOfChangeForMaximumDenomiation() {
        Assert.assertEquals(1, ChangeDP.getCountOfChange(4, ChangeDP.denominationsSorted));
    }

    @Test
    public void testCountOfChangeForNumberMoreThanMaximumDenomiation() {
        Assert.assertEquals(2, ChangeDP.getCountOfChange(5, ChangeDP.denominationsSorted));
    }

}