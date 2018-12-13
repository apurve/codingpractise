package leave.nucleus.linkedlists;

import java.io.PrintStream;
import java.util.Queue;

public class SinglyLinkedList implements LinkedList {

    private Node head;

    @Override
    public int insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return newNode.getData();
    }

    @Override
    public int delete() {
        if(head == null)
            throw new UnsupportedOperationException("List is empty!");
        Node obsoleteNode = head;
        head = head.next;
        return  obsoleteNode.getData();
    }

    @Override
    public void print(PrintStream out) {
        if(head != null) {
            Node traversingNode = head;
            while (traversingNode.next != null) {
                out.println(traversingNode.getData());
                traversingNode = traversingNode.next;
            }
            out.println(traversingNode.getData());
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        if(head != null) {
            Node traversingNode = head;
            while (traversingNode.next != null) {
                builder.append(traversingNode.toString() + ", ");
                traversingNode = traversingNode.next;
            }
            builder.append(traversingNode.getData());
        }
        builder.trimToSize();
        return builder.append("}").toString();
    }


    public String toDataString() {
        StringBuilder builder = new StringBuilder();
        if(head != null) {
            Node traversingNode = head;
            while (traversingNode.next != null) {
                builder.append(traversingNode.getData() + " ");
                traversingNode = traversingNode.next;
            }
            builder.append(traversingNode.getData());
        }
        return builder.toString().trim();
    }

    public Node getHead() {
        return head;
    }

    public int middleNode() {
        return findMiddleNode().getData();
    }

    private Node findMiddleNode() {
        Node traversingNode = head;
        Node middleNode = head;

        while (traversingNode.next != null) {
            traversingNode = traversingNode.next;
            if(traversingNode.next != null) {
                middleNode = traversingNode;
                traversingNode = traversingNode.next;
            }
        }
        return middleNode;
    }

    public int deleteMiddleNode() {
        Node traversingNode = head;
        Node previousToMiddleNode = head;

        int middleNodeData = 0;
        if(traversingNode.next == null) {
            middleNodeData = traversingNode.getData();
        } else {
            while (traversingNode.next.next != null) {
                traversingNode = traversingNode.next.next;
                if(traversingNode.next != null) {
                    previousToMiddleNode = previousToMiddleNode.next;
                } else {
                    break;
                }
            }
        }

        if (previousToMiddleNode.next != null) {
            middleNodeData = previousToMiddleNode.next.getData();
            previousToMiddleNode.next = previousToMiddleNode.next.next;
        } else {
            middleNodeData = previousToMiddleNode.getData();
            head = null;
        }
        return middleNodeData;
    }

    public void reverse() {
        Node current = head;
        Node next = head;
        Node previous = head;
        while (current.next != null) {
            next = current.next;
            if(current == previous) {
                current.next = null;
                current = next;
            } else {
                current.next = previous;
                previous = current;
                current = next;
            }
        }
        head = current;
        current.next = previous;
    }

    public void reverseWithStack() {
        Node current = head;
        Queue<Node> nodesQueue = new java.util.LinkedList<>();
        while (current.next != null) {
            nodesQueue.add(current);
            current = current.next;
        }
        nodesQueue.add(current);
        head = null;
        while (!nodesQueue.isEmpty()) {
            insert(nodesQueue.remove().getData());
        }
    }

}