package leave.nucleus.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class is_bstTest {

    @Test
    public void testCase1() {
        is_bst.IsBST isBST = new is_bst.IsBST();
        isBST.nodes = 3;
        isBST.tree = new is_bst.IsBST.Node[isBST.nodes];
        isBST.tree[0] = new is_bst.IsBST.Node(2, 1, 2);
        isBST.tree[1] = new is_bst.IsBST.Node(1, -1, -1);
        isBST.tree[2] = new is_bst.IsBST.Node(3, -1, -1);
        Assert.assertTrue(isBST.isBinarySearchTree());
    }

    @Test
    public void testCase2() {
        is_bst.IsBST isBST = new is_bst.IsBST();
        isBST.nodes = 3;
        isBST.tree = new is_bst.IsBST.Node[isBST.nodes];
        isBST.tree[0] = new is_bst.IsBST.Node(1, 1, 2);
        isBST.tree[1] = new is_bst.IsBST.Node(2, -1, -1);
        isBST.tree[2] = new is_bst.IsBST.Node(3, -1, -1);
        Assert.assertFalse(isBST.isBinarySearchTree());
    }

    @Test
    public void testCase3() {
        is_bst.IsBST isBST = new is_bst.IsBST();
        isBST.nodes = 0;
        isBST.tree = new is_bst.IsBST.Node[isBST.nodes];
        Assert.assertTrue(isBST.isBinarySearchTree());
    }

    @Test
    public void testCase4() {
        is_bst.IsBST isBST = new is_bst.IsBST();
        isBST.nodes = 5;
        isBST.tree = new is_bst.IsBST.Node[isBST.nodes];
        isBST.tree[0] = new is_bst.IsBST.Node(1, -1, 1);
        isBST.tree[1] = new is_bst.IsBST.Node(2, -1, 2);
        isBST.tree[2] = new is_bst.IsBST.Node(3, -1, 3);
        isBST.tree[3] = new is_bst.IsBST.Node(4, -1, 4);
        isBST.tree[4] = new is_bst.IsBST.Node(5, -1, -1);
        Assert.assertTrue(isBST.isBinarySearchTree());
    }

    @Test
    public void testCase5() {
        is_bst.IsBST isBST = new is_bst.IsBST();
        isBST.nodes = 7;
        isBST.tree = new is_bst.IsBST.Node[isBST.nodes];
        isBST.tree[0] = new is_bst.IsBST.Node(4, 1, 2);
        isBST.tree[1] = new is_bst.IsBST.Node(2, 3, 4);
        isBST.tree[2] = new is_bst.IsBST.Node(6, 5, 6);
        isBST.tree[3] = new is_bst.IsBST.Node(1, -1, -1);
        isBST.tree[4] = new is_bst.IsBST.Node(3, -1, -1);
        isBST.tree[5] = new is_bst.IsBST.Node(5, -1, -1);
        isBST.tree[6] = new is_bst.IsBST.Node(7, -1, -1);
        Assert.assertTrue(isBST.isBinarySearchTree());
    }

    @Test
    public void testCase6() {
        is_bst.IsBST isBST = new is_bst.IsBST();
        isBST.nodes = 4;
        isBST.tree = new is_bst.IsBST.Node[isBST.nodes];
        isBST.tree[0] = new is_bst.IsBST.Node(4, 1, -1);
        isBST.tree[1] = new is_bst.IsBST.Node(2, 2, 3);
        isBST.tree[2] = new is_bst.IsBST.Node(1, -1, -1);
        isBST.tree[3] = new is_bst.IsBST.Node(5, -1, -1);
        Assert.assertFalse(isBST.isBinarySearchTree());
    }

}