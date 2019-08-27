package leave.nucleus.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    public static int numberOfComponents(ArrayList<Integer>[] adj) {
        int connectedComponents = 0;
        //write your code here
        boolean[] visited = new boolean[adj.length];
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                explore(adj, i, visited);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    private static void explore(ArrayList<Integer>[] adj, int x, boolean[] visited) {
        visited[x] = true;
        for(Integer neighbour : adj[x]) {
            if(!visited[neighbour])
                explore(adj, neighbour, visited);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

