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
        Assert.assertTrue(Reachability.reach(getAdjacencyList(n, m, vertices),1-1,4-1));
    }

    @Test
    public void testCase2() {
        int n = 4; // vertices
        int m = 2; // edges
        int [][] vertices = {
                {1,2},
                {3,2}
        };
        Assert.assertFalse(Reachability.reach(getAdjacencyList(n, m, vertices),1-1,4-1));
    }

    private ArrayList<Integer>[] getAdjacencyList(int n, int m, int[][] vertices) {
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = vertices[i][0];
            y = vertices[i][1];
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        return adj;
    }

}