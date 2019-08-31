package leave.nucleus.graphs;

import java.util.ArrayList;

public class GraphExplorationUtils {

    public static void explore(ArrayList<Integer>[] adj, int x, boolean[] visited) {
        visited[x] = true;
        for(Integer neighbour : adj[x]) {
            if(!visited[neighbour])
                explore(adj, neighbour, visited);
        }
    }

}
