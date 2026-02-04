class Solution {
    static class Pair{
        int node;
        int parent;
        public Pair (int node, int parent){
            this.node=node;
            this.parent=parent;
        }
    
    }
    public boolean isCycle(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if (bfs(i, vis, adj)) {
                  return true;
                }
            }
             
        }
        return false;
       
    }
    public boolean bfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q=new LinkedList<Pair>();
        vis[src]=true;
        q.offer(new Pair(src, -1));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int node=curr.node;
            int parent=curr.parent;
            for(int adjNode : adj.get(node)){
                if(vis[adjNode]==false){
                   vis[adjNode]=true;
                   q.offer(new Pair(adjNode, node));
                }
                else if(parent!=adjNode){
                        return true;
                    }
                
                
            }
            
        }
        return false;
    }
}