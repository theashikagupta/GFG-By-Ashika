import java.util.*;

class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        
        // Create adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<>());
        }
        
        // Build graph
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adjList.get(u).add(v);
            adjList.get(v).add(u);  
        }
        
        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        
        // BFS
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.offer(src);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            
            for(int neighbor : adjList.get(curr)){
                if(dist[neighbor] == (int)1e9){
                    dist[neighbor] = dist[curr] + 1;
                    q.offer(neighbor);
                }
            }
        }
        
        // If node is unreachable, return -1
        for(int i=0; i<V; i++){
            if(dist[i] == (int)1e9){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}
