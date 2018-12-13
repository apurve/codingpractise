package leave.nucleus.linkedlists;

import java.io.PrintStream;

public class TwoDLinkedList implements LinkedList {

    private TwoDNode head;

    @Override
    public int insert(int data) {
        TwoDNode newNode = new TwoDNode(data);
        newNode.down = head;
        head = newNode;
        return newNode.getData();
    }

    public TwoDNode insertInRow(int data) {
        TwoDNode newNode = new TwoDNode(data);
        newNode.down = head.down;
        head.down = null;

        newNode.next = head;
        head = newNode;

        return head;
    }

    @Override
    public int delete() {
        if(head == null)
            throw new UnsupportedOperationException("Matrix is empty!");
        TwoDNode obsoleteNode = head;
        head = (TwoDNode) head.next;
        head.down = obsoleteNode.down;
        return  obsoleteNode.getData();
    }

    @Override
    public void print(PrintStream out) {
        if(head != null) {
            TwoDNode traversingNode = head;
            while (traversingNode.down != null) {
                printRow(traversingNode, out);
                out.println();out.println("|");
                traversingNode = traversingNode.down;
            }
            printRow(traversingNode, out);
        }
    }

    private void printRow(TwoDNode traversingNode, PrintStream out) {
        while (traversingNode.next != null) {
            out.print(traversingNode.getData() + "->");
            traversingNode = (TwoDNode) traversingNode.next;
        }
        out.print(traversingNode.getData());
    }

    @Override
    public TwoDNode getHead() {
        return this.head;
    }

    public String flatten() {
        StringBuilder flatString = new StringBuilder();
        this.head = flatten(this.head);
        return flatString.toString();
    }

    private TwoDNode flatten(TwoDNode head) {
        if(head == null || head.down == null) {
            return head;
        }
        head = merge(head, head.down);
        head = flatten(head);
        return head;
    }

    private TwoDNode merge(TwoDNode head, TwoDNode down) {
        if(head == null || down == null) {
            return head;
        }
        TwoDNode matrixHolder = down.down;

        if(head.getData() < down.getData()) {
            TwoDNode nextTemp = (TwoDNode) head.next;
            head.next = down;
            head.down = (TwoDNode) head.down.next;
            head.next.next = nextTemp;
        } else {

        }
        return head;
    }

}