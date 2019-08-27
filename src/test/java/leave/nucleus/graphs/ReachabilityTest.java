package leave.nucleus.graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ReachabilityTest {

    @Test
    public void testCase1() {
        int n = 4; // vertices
        int m = 4; // edges
        int [][] vertices = {
                {1,2},
                {3,2},
                {4,3},
                {1,4}
        };
        Assert.assertTrue(Reachability.reach(GraphsRepresentationUtil.getAdjacencyList(n, m, vertices),1-1,4-1));
    }

    @Test
    public void testCase2() {
        int n = 4; // vertices
        int m = 2; // edges
        int [][] vertices = {
                {1,2},
                {3,2}
        };
        Assert.assertFalse(Reachability.reach(GraphsRepresentationUtil.getAdjacencyList(n, m, vertices),1-1,4-1));
    }



}