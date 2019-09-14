package leave.nucleus.graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DijkstraTest {

    @Test
    public void testCase1() {
        int n = 4; // vertices
        int m = 4; // edges
        int [][] vertices = {
                {1,2,1},
                {4,1,2},
                {2,3,2},
                {1,3,5}
        };
        int u=1, v=3;
        Assert.assertEquals(3, Dijkstra.distance(GraphRepresentationUtil.getWeightedAdjacencyList(n, m, vertices),u-1,v-1));
    }

    @Test
    public void testCase2() {
        int n = 5; // vertices
        int m = 9; // edges
        int [][] vertices = {
                {1,2,4},
                {1,3,2},
                {2,3,2},
                {3,2,1},
                {2,4,2},
                {3,5,4},
                {5,4,1},
                {2,5,3},
                {3,4,4}
        };
        int u=1, v=5;
        Assert.assertEquals(6, Dijkstra.distance(GraphRepresentationUtil.getWeightedAdjacencyList(n, m, vertices),u-1,v-1));
    }

    @Test
    public void testCase3() {
        int n = 3; // vertices
        int m = 3; // edges
        int [][] vertices = {
                {1,2,7},
                {1,3,5},
                {2,3,2}
        };
        int u=3, v=2;
        Assert.assertEquals(-1, Dijkstra.distance(GraphRepresentationUtil.getWeightedAdjacencyList(n, m, vertices),u-1,v-1));
    }

}