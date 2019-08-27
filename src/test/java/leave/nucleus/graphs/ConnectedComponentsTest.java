package leave.nucleus.graphs;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConnectedComponentsTest {

    @Test
    public void testCase() {
        int n = 4; // vertices
        int m = 2; // edges
        int [][] vertices = {
                {1,2},
                {3,2}
        };
        Assert.assertEquals(2, ConnectedComponents.numberOfComponents(GraphsRepresentationUtil.getAdjacencyList(n, m, vertices)));
    }

}