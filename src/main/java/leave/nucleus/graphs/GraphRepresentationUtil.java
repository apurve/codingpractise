package leave.nucleus.graphs;

import java.util.ArrayList;

public class GraphRepresentationUtil {

    public static ArrayList<Integer>[] getAdjacencyList(int n, int m, int[][] vertices) {
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = vertices[i][0];
            y = vertices[i][1];
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        return adj;
    }

}
