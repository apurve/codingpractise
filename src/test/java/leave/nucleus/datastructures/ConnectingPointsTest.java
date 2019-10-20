package leave.nucleus.datastructures;

import leave.nucleus.graphs.ConnectingPoints;
import org.junit.Assert;
import org.junit.Test;

public class ConnectingPointsTest {

    @Test
    public void testCase1() {
        int x[] = {0,0,1,1}, y[] = {0,1,0,1};
        Assert.assertEquals(3.000000000, ConnectingPoints.minimumDistance(x, y), 0);
    }

    @Test
    public void testCase2() {
        int x[] = {0,0,1,3,3}, y[] = {0,2,1,0,2};
        Assert.assertEquals(7.064495102, ConnectingPoints.minimumDistance(x, y), 0);
    }

    @Test
    public void testCase3() {
        int x[] = {}, y[] = {};
        Assert.assertEquals(0, ConnectingPoints.minimumDistance(x, y), 0);
    }

    @Test
    public void testCase4() {
        int x[] = {0}, y[] = {0};
        Assert.assertEquals(0, ConnectingPoints.minimumDistance(x, y), 0);
    }

    @Test
    public void testCase5() {
        int x[] = {0,0,-1,-1}, y[] = {0,-1,0,-1};
        Assert.assertEquals(3.000000000, ConnectingPoints.minimumDistance(x, y), 0);
    }
}