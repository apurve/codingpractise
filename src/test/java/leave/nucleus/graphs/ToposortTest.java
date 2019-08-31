package leave.nucleus.graphs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToposortTest {

    @Test
    public void testCase1() {
        int n = 4; // vertices
        int m = 3; // edges
        int [][] vertices = {
                {1,2},
                {4,1},
                {3,1}
        };
        for(Integer item : Toposort.toposort(GraphRepresentationUtil.getDirectedAdjacencyList(n, m, vertices))) {
            System.out.print(item + 1 + " ");

        }
    }

    @Test
    public void testCase2() {
        int n = 4; // vertices
        int m = 1; // edges
        int [][] vertices = {
                {3,1}
        };
        for(Integer item : Toposort.toposort(GraphRepresentationUtil.getDirectedAdjacencyList(n, m, vertices))) {
            System.out.print(item + 1 + " ");

        }
    }

    @Test
    public void testCase3() {
        int n = 5; // vertices
        int m = 7; // edges
        int [][] vertices = {
                {2,1},
                {3,2},
                {3,1},
                {4,3},
                {4,1},
                {5,2},
                {5,3}
        };
        for(Integer item : Toposort.toposort(GraphRepresentationUtil.getDirectedAdjacencyList(n, m, vertices))) {
            System.out.print(item + 1 + " ");

        }
    }
}