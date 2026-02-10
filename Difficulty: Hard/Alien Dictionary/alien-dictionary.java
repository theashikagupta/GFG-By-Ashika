class Solution {
    public String findOrder(String[] words) {
        int K = 26;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[K];
        Arrays.fill(indegree, -1);

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        // Mark all characters that appear
        for (String w : words) {
            for (char c : w.toCharArray()) {
                if (indegree[c - 'a'] == -1) {
                    indegree[c - 'a'] = 0;
                }
            }
        }

        // Build graph using adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            // Invalid prefix case
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }

            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                char u = w1.charAt(j);
                char v = w2.charAt(j);

                if (u != v) {
                    adj.get(u - 'a').add(v - 'a');
                    indegree[v - 'a']++;
                    break; // only first mismatch matters
                }
            }
        }

        // Count total unique characters
        int totalChars = 0;
        for (int i = 0; i < K; i++) {
            if (indegree[i] != -1) totalChars++;
        }

        // Kahn's BFS
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append((char)(curr + 'a'));

            for (int nei : adj.get(curr)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // Cycle check
        return sb.length() == totalChars ? sb.toString() : "";
    }
}
