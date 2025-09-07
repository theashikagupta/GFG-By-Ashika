class Solution {
    public int minOperations(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int steps = (c == 'a') ? 0 : ('z' - c + 1); 
            result = Math.max(result, steps);
        }
        return result;
    }
}

