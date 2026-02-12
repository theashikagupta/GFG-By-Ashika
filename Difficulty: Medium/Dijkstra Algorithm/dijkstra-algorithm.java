class Solution {

    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));  // remove this if graph is directed
        }

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.dist, b.dist)
        );

        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;

            if (d > distance[u]) continue;  // very important

            for (Pair p : adj.get(u)) {

                int v = p.node;
                int weight = p.dist;

                if (distance[v] > distance[u] + weight) {
                    distance[v] = distance[u] + weight;
                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }

        return distance;
    }
}
