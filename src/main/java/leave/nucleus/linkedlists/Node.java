package leave.nucleus.linkedlists;

public class Node {

    public Node next;
    public Node previous;
    private int data;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", previous=" + previous +
                ", data=" + data +
                '}';
    }
}