package leave.nucleus.graphs;

import java.util.*;

public class Dijkstra {

    public static int distance(ArrayList<Vertex>[] adj, int s, int t) {
        int[] distance = new int[adj.length];
        int[] previous = new int[adj.length];
        initializeDistanceAndPreviousArray(distance, previous, s);
        PriorityQueue<Vertex> priorityQueue = initializePriorityQueue(adj, s);
        while (!priorityQueue.isEmpty()) {
            Vertex visiting = priorityQueue.remove();
            for(Vertex neighbour : adj[visiting.node]) {
                if(distance[neighbour.node] > distance[visiting.node] + neighbour.cost) {
                    distance[neighbour.node] = distance[visiting.node] + neighbour.cost;
                    previous[neighbour.node] = visiting.node;
                    Vertex subPathVertex = new Vertex(neighbour.node, distance[neighbour.node]);
                    priorityQueue.add(subPathVertex);
                }

            }
        }
        return distance[t] < Integer.MAX_VALUE ? distance[t] : -1;
    }

    private static PriorityQueue<Vertex> initializePriorityQueue(ArrayList<Vertex>[] adj, int source) {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.cost.compareTo(o2.cost);
            }
        });
        Vertex sourceVertex = new Vertex(source,0);
        priorityQueue.add(sourceVertex);
        /*for(int i = 0; i < adj.length; i++) {
            for(Vertex vertex : adj[i]) {
                priorityQueue.add(vertex);
            }
        }*/
        return priorityQueue;
    }

    private static int[] initializeDistanceAndPreviousArray(int[] distance, int[] previous, int source) {
        for(int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            previous[i] = -1;
        }
        distance[source] = 0;
        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Vertex>[] adj = (ArrayList<Vertex>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Vertex>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            Vertex vertex = new Vertex(y-1, w);
            adj[x - 1].add(vertex);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }

}