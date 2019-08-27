package leave.nucleus.datastructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class tree_ordersTest {

    @Test
    public void testTraversal2() {
        tree_orders.TreeOrders tree = new tree_orders.TreeOrders();
        tree.key = new int[] {0,10,20,30,40,50,60,70,80,90};
        tree.left = new int[] {7,-1,-1,8,3,-1,1,5,-1,-1};
        tree.right = new int[] {2,-1,6,9,-1,-1,-1,4,-1,-1};

        Assert.assertEquals(Arrays.asList(50,70,80,30,90,40,0,20,10,60), tree.inOrder());
        Assert.assertEquals(Arrays.asList(0,70,50,40,30,80,90,20,60,10), tree.preOrder());
        Assert.assertEquals(Arrays.asList(50,80,90,30,40,70,10,60,20,0), tree.postOrder());
    }

    @Test
    public void testTraversal1() {
        tree_orders.TreeOrders tree = new tree_orders.TreeOrders();
        tree.key = new int[] {4,2,5,1,3};
        tree.left = new int[] {1,3,-1,-1,-1};
        tree.right = new int[] {2,4,-1,-1,-1};

        Assert.assertEquals(Arrays.asList(1,2,3,4,5), tree.inOrder());
        Assert.assertEquals(Arrays.asList(4,2,1,3,5), tree.preOrder());
        Assert.assertEquals(Arrays.asList(1,3,2,5,4), tree.postOrder());
    }

}