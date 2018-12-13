package leave.nucleus.linkedlists;

import org.junit.Before;
import org.junit.Test;

public class TestTwoDLinkedList {

    private TwoDLinkedList list = null;

    @Before
    public void setupTest() {
        list = new TwoDLinkedList();
        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        list.insert(30);
        list.insertInRow(8);
        list.insertInRow(7);
        list.insertInRow(5);

        list.insert(20);
        list.insertInRow(10);

        list.insert(50);
        list.insertInRow(22);
        list.insertInRow(19);

        list.insert(45);
        list.insertInRow(40);
        list.insertInRow(35);
        list.insertInRow(28);
    }

    @Test
    public void testListCreation() {
        list.print(System.out);
    }



}
