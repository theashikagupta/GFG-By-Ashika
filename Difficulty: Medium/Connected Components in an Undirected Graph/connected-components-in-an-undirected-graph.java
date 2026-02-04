class Solution {
    
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0; i<=V; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                ans.add(BFS(i, adjList, vis));
            }
        }

        return ans;
    }
    public static ArrayList<Integer> BFS(int src,ArrayList<ArrayList<Integer>> adjList,boolean[] vis ){
        
        ArrayList<Integer> component=new ArrayList<>();
        
        Queue<Integer> q=new LinkedList<>();
       
        vis[src]=true;
        q.offer(src);
        while(!q.isEmpty()){
            int curr=q.poll();
            component.add(curr);
            for(int adj : adjList.get(curr)){
                if(vis[adj]==false){
                   vis[adj]=true;
                   q.offer(adj);
                }
            }
            
        }
        return component;
        
    }
}