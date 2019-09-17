package leave.nucleus.datastructures;

import java.util.*;
import java.io.*;

public class is_bst_hard {
    static class FastScanner {
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
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static class IsBST {
        static class Node {
            long key;
            int left;
            int right;

            Node(long key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextLong(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            return tree.length > 0 ? isBinarySearchTree(tree[0], Long.MIN_VALUE, Long.MAX_VALUE) : true;
        }

        public boolean isBinarySearchTree(Node root, long min, long max) {
            if(root.key < min || root.key > max)
                return false;
            boolean leftBST = true, rightBST = true;
            if(root.left != -1)
                leftBST = isBinarySearchTree(tree[root.left], min, root.key - 1);
            if(root.right != -1)
                rightBST = isBinarySearchTree(tree[root.right], root.key, max);
            return leftBST && rightBST;
        }

    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }

}
