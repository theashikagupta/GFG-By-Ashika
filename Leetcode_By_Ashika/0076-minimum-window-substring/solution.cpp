class Solution {
public:
    string minWindow(string s, string t) {
        if (s.empty() || t.empty()) return "";

        int total = t.length();
        unordered_map<char, int> map;

        // store freq of t
        for (char c : t) {
            map[c]++;
        }

        int start = 0, end = 0;
        int minLen = INT_MAX, minStart = 0;

        while (end < s.length()) {
            char cEnd = s[end];
            if (map.find(cEnd) != map.end()) {
                map[cEnd]--;
                if (map[cEnd] >= 0) {
                    total--;
                }
            }

            // shrink window from left if all chars found
            while (total == 0) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                char cStart = s[start];
                if (map.find(cStart) != map.end()) {
                    map[cStart]++;
                    if (map[cStart] > 0) {
                        total++;
                    }
                }
                start++;
            }
            end++;
        }

        return (minLen == INT_MAX) ? "" : s.substr(minStart, minLen);
    }
};

