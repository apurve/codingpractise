package leave.nucleus.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class NegativeCycle {
    public static int negativeCycle(ArrayList<Vertex>[] adj) {
        // write your code here
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Vertex>[] adj = (ArrayList<Vertex>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Vertex>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            Vertex node = new Vertex(y - 1, 2);
            adj[x - 1].add(node);
        }
        System.out.println(negativeCycle(adj));
    }

}