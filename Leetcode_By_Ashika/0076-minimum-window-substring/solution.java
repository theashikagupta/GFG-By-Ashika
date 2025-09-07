class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        int[] freq = new int[128];
        for (char c : t.toCharArray()) {freq[c]++;}

        int start = 0, end = 0;
        int total = t.length();
        int minLen = Integer.MAX_VALUE, minStart = 0;

        while (end < s.length()) {
            char ch = s.charAt(end);
            if (freq[ch] > 0) 
            total--;  // char is needed
            freq[ch]--;
            end++;  // expand window

            // shrink window while valid
            while (total == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                }

                char startChar = s.charAt(start);
                freq[startChar]++;
                if (freq[startChar] > 0) total++;  // window lost a required char
                start++;  // shrink
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minStart, minStart + minLen);
    }
}

