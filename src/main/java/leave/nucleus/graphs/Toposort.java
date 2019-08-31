package leave.nucleus.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {

    public static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean visited[] = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        //write your code here
        dfs(adj, order);
        Collections.reverse(order);
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, ArrayList<Integer> order) {
        boolean[] visited = new boolean[adj.length];
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                explore(adj, i, visited, order);
            }
        }
    }

    private static void explore(ArrayList<Integer>[] adj, int x, boolean[] visited,  ArrayList<Integer> order) {
        visited[x] = true;
        for(Integer neighbour : adj[x]) {
            if(!visited[neighbour])
                explore(adj, neighbour, visited, order);
        }
        order.add(x);
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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

