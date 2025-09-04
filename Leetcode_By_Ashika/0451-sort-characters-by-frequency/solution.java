class Solution {
    public String frequencySort(String s) {
        //bucket sort
        int n = s.length();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        // Count frequency
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Create buckets
        List<Character>[] bucket = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            bucket[i] = new ArrayList<>();
        }
        
        // Fill buckets
        for (var entry : freqMap.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }
        
        // Build result string
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {   // FIXED condition
            for (char ch : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
    }
}

