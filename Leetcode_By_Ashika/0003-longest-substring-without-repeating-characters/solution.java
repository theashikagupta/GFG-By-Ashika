import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLen = 0;
        HashSet<Character> seen = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            // if char already in set, remove from left until unique
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }

            // add current char to set
            seen.add(s.charAt(right));

            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

