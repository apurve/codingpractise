package leave.nucleus.linkedlists;

import java.io.PrintStream;

public interface LinkedList {

    int insert(int data);

    int delete();

    void print(PrintStream out);

    Node getHead();
}
