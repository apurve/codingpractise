package leave.nucleus.datastructures;

import java.util.*;
import java.io.*;

public class tree_height {

    public static void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}

class Node {
    int value;
    List<Node> children;

    Node(int value) {
        this.value = value;
        children = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(value);
        if(children != null && !children.isEmpty()) {
            for (Node child : children) {
                stringBuilder.append(child.toString());
            }
        }
        return stringBuilder.toString();
    }

    public int computeHeight() {
        int height = 1;
        if(children != null && !children.isEmpty()) {
            int maxChildHeight = 0;
            for (Node child : children) {
                int childHeight = child.computeHeight();
                if(maxChildHeight < childHeight)
                    maxChildHeight = childHeight;
            }
            height += maxChildHeight;
        }
        return height;
    }

}

class TreeHeight {
    int n;
    int parents[];
    Node root = null;
    HashMap<Integer, List<Node>> childrenMap = new HashMap<Integer, List<Node>>();

    void read() throws IOException {
        FastScanner in = new FastScanner();
        n = in.nextInt();
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = in.nextInt();
        }
        buildTree();
    }

    void buildTree() {
        for(int nodeValue = 0; nodeValue < parents.length; nodeValue++) {
            if(parents[nodeValue] == -1) {
                root = new Node(nodeValue);
            } else {
                Node temp = new Node(nodeValue);
                /*if(childrenMap.containsKey(nodeValue)) {
                    temp.children = childrenMap.get(nodeValue);
                    childrenMap.remove(nodeValue);
                }*/
                if(childrenMap.containsKey(parents[nodeValue])) {
                    childrenMap.get(parents[nodeValue]).add(temp);
                } else {
                    List<Node> childrenList = new ArrayList<Node>();
                    childrenList.add(temp);
                    childrenMap.put(parents[nodeValue], childrenList);
                }
            }
        }
        addChildren(root, childrenMap.get(root.value));
    }

    private void addChildren(Node root, List<Node> nodes) {
        if(nodes == null || nodes.isEmpty())
            return;
        root.children.addAll(nodes);
        childrenMap.remove(root.value);
        for(Node child : nodes) {
            addChildren(child, childrenMap.get(child.value));
        }
    }

    int computeHeight() {
        // Replace this code with a faster implementation
        return root.computeHeight();
    }

    @Override
    public String toString() {
        return root != null ? root.toString() : null;
    }
}

class FastScanner {
    StringTokenizer tok = new StringTokenizer("");
    BufferedReader in;

    FastScanner() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (!tok.hasMoreElements())
            tok = new StringTokenizer(in.readLine());
        return tok.nextToken();
    }
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}