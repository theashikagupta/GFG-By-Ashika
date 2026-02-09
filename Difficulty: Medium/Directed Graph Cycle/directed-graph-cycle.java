import java.util.*;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        
        // 1. Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]); // u -> v
        }
        
        // 2. Arrays for DFS
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        
        // 3. Check cycle for each node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack))
                    return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                        boolean[] visited, boolean[] recStack) {
        
        visited[node] = true;
        recStack[node] = true;
        
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, recStack))
                    return true;
            }
            else if (recStack[neighbour]) {
                return true; // cycle found
            }
        }
        
        recStack[node] = false; // backtrack
        return false;
    }
}
