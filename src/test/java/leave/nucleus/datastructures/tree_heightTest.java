package leave.nucleus.datastructures;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class tree_heightTest {

    @Test
    public void testCreateTree1() {
        TreeHeight tree = new TreeHeight();
        tree.n = 5;
        tree.parents = new int[] {4, -1, 4, 1, 1};
        tree.buildTree();
        Assert.assertEquals("13402", tree.toString());
    }

    @Test
    public void testTreeHeight1() {
        TreeHeight tree = new TreeHeight();
        tree.n = 5;
        tree.parents = new int[] {4, -1, 4, 1, 1};
        tree.buildTree();
        Assert.assertEquals(3, tree.computeHeight());
    }

    @Test
    public void testCreateTree2() {
        TreeHeight tree = new TreeHeight();
        tree.n = 5;
        tree.parents = new int[] {-1, 0, 4, 0, 3};
        tree.buildTree();
        Assert.assertEquals("01342", tree.toString());
    }

    @Test
    public void testTreeHeight2() {
        TreeHeight tree = new TreeHeight();
        tree.n = 5;
        tree.parents = new int[] {-1, 0, 4, 0, 3};
        tree.buildTree();
        Assert.assertEquals(4, tree.computeHeight());
    }

    @Test
    public void testCreateTree3() {
        TreeHeight tree = new TreeHeight();
        tree.n = 10;
        tree.parents = new int[] {9, 7, 5, 5, 2, 9, 9, 9, 2, -1};
        tree.buildTree();
        Assert.assertEquals("9052483671", tree.toString());
    }

    @Test
    public void testTreeHeight3() {
        TreeHeight tree = new TreeHeight();
        tree.n = 10;
        tree.parents = new int[] {9, 7, 5, 5, 2, 9, 9, 9, 2, -1};
        tree.buildTree();
        Assert.assertEquals(4, tree.computeHeight());
    }
}