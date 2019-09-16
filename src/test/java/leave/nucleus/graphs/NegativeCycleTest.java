package leave.nucleus.graphs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NegativeCycleTest {

    @Test
    public void testCase1() {
        int n = 4; // vertices
        int m = 4; // edges
        int [][] vertices = {
                {1,2,-5},
                {4,1,2},
                {2,3,2},
                {3,1,1}
        };
        Assert.assertTrue(NegativeCycle.negativeCycle(GraphRepresentationUtil.getWeightedAdjacencyList(n, m, vertices)));
    }

    @Test
    public void testCase2() {
        int n = 4; // vertices
        int m = 4; // edges
        int [][] vertices = {
                {1,2,1},
                {4,1,2},
                {2,3,2},
                {3,1,-5}
        };
        Assert.assertTrue(NegativeCycle.negativeCycle(GraphRepresentationUtil.getWeightedAdjacencyList(n, m, vertices)));
    }

}