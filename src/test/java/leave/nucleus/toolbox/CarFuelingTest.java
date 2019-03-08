package leave.nucleus.toolbox;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class CarFuelingTest {

    @Test
    public void testCarFueling() {
        BigInteger dist = BigInteger.valueOf(950);
        int tank = 400;
        int n = 4;
        int stops[] = new int[n];
        stops[0] = 200;
        stops[1] = 275;
        stops[2] = 550;
        stops[3] = 750;
        Assert.assertEquals(2, CarFueling.computeMinRefills(dist, tank, stops));
    }

    @Test
    public void testCarFuelingFromCoursera() {
        BigInteger dist = BigInteger.valueOf(500);
        int tank = 200;
        int n = 4;
        int stops[] = new int[n];
        stops[0] = 100;
        stops[1] = 200;
        stops[2] = 300;
        stops[3] = 400;
        Assert.assertEquals(2, CarFueling.computeMinRefills(dist, tank, stops));
    }

    @Test
    public void testCannotReach() {
        BigInteger dist = BigInteger.valueOf(10);
        int tank = 3;
        int n = 4;
        int stops[] = new int[n];
        stops[0] = 1;
        stops[1] = 2;
        stops[2] = 5;
        stops[3] = 9;
        Assert.assertEquals(-1, CarFueling.computeMinRefills(dist, tank, stops));
    }
}
