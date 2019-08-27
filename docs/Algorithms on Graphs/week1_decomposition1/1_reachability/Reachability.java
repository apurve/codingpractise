import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reachability {

    public static boolean reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
        boolean[] visited = new boolean[adj.length];
        explore(adj, x, visited);
        return visited[y];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y) ? 1 : 0);
    }
}

