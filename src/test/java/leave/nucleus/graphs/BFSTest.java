package leave.nucleus.graphs;

import org.junit.Assert;
import org.junit.Test;

public class BFSTest {

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
        Assert.assertEquals(2, BFS.distance(GraphRepresentationUtil.getAdjacencyList(n, m, vertices), 2-1, 4-1));
    }

    @Test
    public void testCase2() {
        int n = 5; // vertices
        int m = 4; // edges
        int [][] vertices = {
                {5,2},
                {1,3},
                {3,4},
                {1,4}
        };
        Assert.assertEquals(-1, BFS.distance(GraphRepresentationUtil.getAdjacencyList(n, m, vertices), 3-1, 5-1));
    }

}