package leave.nucleus.graphs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AcyclicityTest {

    @Test
    public void testCase1() {
        int n = 4; // vertices
        int m = 4; // edges
        int [][] vertices = {
                {1,2},
                {4,1},
                {2,3},
                {3,1}
        };
        Assert.assertTrue(Acyclicity.acyclic(GraphRepresentationUtil.getDirectedAdjacencyList(n, m, vertices)));
    }

    @Test
    public void testCase2() {
        int n = 5; // vertices
        int m = 7; // edges
        int [][] vertices = {
                {1,2},
                {2,3},
                {1,3},
                {3,4},
                {1,4},
                {2,5},
                {3,5}
        };
        Assert.assertFalse(Acyclicity.acyclic(GraphRepresentationUtil.getDirectedAdjacencyList(n,m,vertices)));
    }

    @Test
    public void testCase3() {
        int n = 4; // vertices
        int m = 3; // edges
        int [][] vertices = {
                {1,2},
                {3,2},
                {4,3}
        };
        Assert.assertFalse(Acyclicity.acyclic(GraphRepresentationUtil.getDirectedAdjacencyList(n, m, vertices)));
    }
}