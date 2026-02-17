class Solution {
    // Function to detect cycle using DSU in an undirected graph.
    static int[] parent;
    static int[] rank;
    
    
    // FIND with Path Compression
    public int find(int x) {
        if (parent[x] == x) {
             return x;
        }
        return  parent[x] = find(parent[x]);  // path compression
    }

    // UNION by Rank
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;  // already in same set

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        parent = new int[V];
        rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;   // every node is its own parent
            rank[i] = 0;
        }
        
        for(int u=0 ; u<V ;u++){
            for(int v:adj.get(u)){
                if(u<v){
                    int par_u=find(u);
                    int par_v=find(v);
                    if(par_u==par_v){
                        return 1;
                    }
                    union(u,v);
                }
            }
            
        }
        return 0;
    }

    
   
}