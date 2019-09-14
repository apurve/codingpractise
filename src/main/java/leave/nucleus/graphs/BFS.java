package leave.nucleus.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static int distance(ArrayList<Integer>[] adj, int s, int t) {
        int[] distance = initializeDistanceArray(adj.length, s);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int exploring = queue.remove();
            for(Integer neighbour : adj[exploring]) {
                if(distance[neighbour] > adj.length) {
                    distance[neighbour] = distance[exploring] + 1;
                    queue.add(neighbour);
                }
            }
        }
        return distance[t] < adj.length ? distance[t] : -1;
    }

    private static int[] initializeDistanceArray(int length, int source) {
        int[] distance = new int[length];
        for(int i = 0; i < distance.length; i++) {
            distance[i] = distance.length + 1;
        }
        distance[source] = 0;
        return distance;
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
        System.out.println(distance(adj, x, y));
    }
}

