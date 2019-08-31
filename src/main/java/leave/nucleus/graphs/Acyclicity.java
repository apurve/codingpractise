package leave.nucleus.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {

    public static boolean acyclic(ArrayList<Integer>[] adj) {
        boolean[] visited = new boolean[adj.length];
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                boolean[] recursionStack = new boolean[adj.length];
                if(exploreForCycles(adj, i, visited, recursionStack))
                    return true;
            }
        }
        return false;
    }

    private static boolean exploreForCycles(ArrayList<Integer>[] adj, int x, boolean[] visited, boolean[] recursionStack) {
        visited[x] = true;
        for(Integer neighbour : adj[x]) {
            if(!visited[neighbour]) {
                recursionStack[x] = true;
                if(exploreForCycles(adj, neighbour, visited, recursionStack))
                    return true;
                recursionStack[x]=false;
            }
            else if(recursionStack[neighbour])
                return true;
        }
        return false;
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
        System.out.println(acyclic(adj)?1:0);
    }
}

