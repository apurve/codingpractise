package leave.nucleus.graphs;

import java.awt.geom.Point2D;
import java.text.NumberFormat;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectingPoints {
    public static double minimumDistance(int[] x, int[] y) {
        if(x.length == 0)
            return 0d;
        double[] cost = initializeCosts(x.length);
        int[] parent = new int[x.length];
        boolean[] visited = new boolean[x.length];
        PriorityQueue<Road> roads = initializeRoads();
        while (!roads.isEmpty()) {
            Road road = roads.remove();
            visited[road.station] = true;
            for(int neighbour=0; neighbour<visited.length; neighbour++) {
                if(!visited[neighbour]) {
                    double costToNeighbour = computeCost(x[road.station], y[road.station], x[neighbour], y[neighbour]);
                    if(cost[neighbour] > costToNeighbour) {
                        cost[neighbour] = costToNeighbour;
                        parent[neighbour] = road.station;
                        //updateRoads(roads, new Road(costToNeighbour, neighbour));
                        roads.add(new Road(costToNeighbour, neighbour));
                    }
                }
            }
        }
        return computeTotalCost(cost);
    }

    private static void updateRoads(PriorityQueue<Road> roads, Road road) {
        boolean add = true;
        for(Road station : roads) {
            if(station.station == road.station) {
                station.cost = road.cost;
                add = false;
            }
        }
        if(add)
            roads.add(road);
    }

    private static double[] initializeCosts(int length) {
        double[] costs = new double[length];
        for (int i=1; i<length; i++) {
            costs[i] = Double.MAX_VALUE;
        }
        return costs;
    }

    private static double computeCost(int x1, int y1, int x2, int y2) {
        return Point2D.distance(x1, y1, x2, y2);
    }

    private static double computeTotalCost(double[] costs) {
        double totalCost = 0d;
        for(double cost : costs) {
            totalCost += cost;
        }
        return formatTotalCostTo9Places(totalCost);
    }

    private static double formatTotalCostTo9Places(double totalCost) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(9);
        return Double.valueOf(nf.format(totalCost));
    }

    private static PriorityQueue<Road> initializeRoads() {
        PriorityQueue<Road> roads = new PriorityQueue<>();
        roads.add(new Road(0d, 0));
        return roads;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }

    static class Road implements Comparable {
        Double cost;
        int station;

        public Road(Double cost, int station) {
            this.cost = cost; this.station = station;
        }

        @Override
        public int compareTo(Object o) {
            return this.cost.compareTo(((Road)o).cost);
        }
    }

}