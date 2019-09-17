package leave.nucleus.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class NegativeCycle {

    public static boolean negativeCycle(ArrayList<Vertex>[] adj) {
        int source = 0, iterations = adj.length - 1;
        int[] distance = new int[adj.length];
        int[] previous = new int[adj.length];
        initializeDistanceAndPreviousArray(distance, previous, source);
        PriorityQueue<Vertex> priorityQueue = initializePriorityQueue();
        while (iterations >= 0) {
            if(priorityQueue.isEmpty()) {
                priorityQueue.add(new Vertex(source,0));
            }
            Vertex visiting = priorityQueue.remove();
            for(Vertex neighbour : adj[visiting.node]) {
                if(relax(distance, previous, priorityQueue, visiting, neighbour) && iterations == 0)
                    return true;
            }
            iterations--;
        }
        return false;
    }

    private static PriorityQueue<Vertex> initializePriorityQueue() {
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.cost.compareTo(o2.cost);
            }
        });
        return priorityQueue;
    }

    private static boolean relax(int[] distance, int[] previous, PriorityQueue<Vertex> priorityQueue, Vertex visiting, Vertex neighbour) {
        if(distance[neighbour.node] > distance[visiting.node] + neighbour.cost) {
            distance[neighbour.node] = distance[visiting.node] + neighbour.cost;
            previous[neighbour.node] = visiting.node;
            Vertex subPathVertex = new Vertex(neighbour.node, distance[neighbour.node]);
            priorityQueue.add(subPathVertex);
            return true;
        }
        return false;
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
        System.out.println(negativeCycle(adj) ? 1 : 0);
    }

}