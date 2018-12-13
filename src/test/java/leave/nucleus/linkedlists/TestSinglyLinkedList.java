package leave.nucleus.linkedlists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSinglyLinkedList {

    SinglyLinkedList singlyLinkedList;

    @Before
    public void setUp() {
        singlyLinkedList = new SinglyLinkedList();
    }

    @Test
    public void testNewNodeInsertion() {
        singlyLinkedList.insert(5);

        Assert.assertEquals(null, singlyLinkedList.getHead().next);
    }

    @Test
    public void testSingleNodeDeletion() {
        singlyLinkedList.insert(5);
        singlyLinkedList.delete();
        Assert.assertEquals(null, singlyLinkedList.getHead());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testNodeDeletionOnEmptyList() {
        singlyLinkedList.insert(5);
        singlyLinkedList.delete();
        singlyLinkedList.delete();
    }

    @Test
    public void testConsecutiveInsertionAndDeletion() {
        singlyLinkedList.insert(5);
        singlyLinkedList.insert(6);
        singlyLinkedList.insert(7);

        Assert.assertEquals(7, singlyLinkedList.delete());
        Assert.assertEquals(6, singlyLinkedList.delete());

        singlyLinkedList.insert(8);
        Assert.assertEquals(8, singlyLinkedList.delete());
        Assert.assertEquals(5, singlyLinkedList.delete());
    }

    @Test
    public void testMiddleElementWithOddCountOfElements() {
        singlyLinkedList.insert(5);
        singlyLinkedList.insert(6);
        singlyLinkedList.insert(7);

        Assert.assertEquals(6, singlyLinkedList.middleNode());
    }

    @Test
    public void testMiddleElementWithEvenCountOfElements() {
        singlyLinkedList.insert(5);
        singlyLinkedList.insert(6);
        singlyLinkedList.insert(7);
        singlyLinkedList.insert(8);

        Assert.assertEquals(7, singlyLinkedList.middleNode());
    }

    @Test
    public void testMiddleElementDeletionWithSingleElementList() {
        singlyLinkedList.insert(8);

        Assert.assertEquals(8, singlyLinkedList.deleteMiddleNode());
        Assert.assertEquals("", singlyLinkedList.toDataString());
    }

    @Test
    public void testMiddleElementDeletion() {
        singlyLinkedList.insert(6);
        singlyLinkedList.insert(7);
        singlyLinkedList.insert(8);
        singlyLinkedList.insert(9);

        Assert.assertEquals(7, singlyLinkedList.deleteMiddleNode());
        Assert.assertEquals("9 8 6", singlyLinkedList.toDataString());
    }

    @Test
    public void reverseListTest() {
        singlyLinkedList.insert(6);
        singlyLinkedList.insert(7);
        singlyLinkedList.insert(8);
        singlyLinkedList.insert(9);

        singlyLinkedList.reverse();
        Assert.assertEquals("6 7 8 9", singlyLinkedList.toDataString());
    }

    @Test
    public void reverseListWithStackTest() {
        singlyLinkedList.insert(6);
        singlyLinkedList.insert(7);
        singlyLinkedList.insert(8);
        singlyLinkedList.insert(9);

        singlyLinkedList.reverseWithStack();
        Assert.assertEquals("6 7 8 9", singlyLinkedList.toDataString());
    }

}