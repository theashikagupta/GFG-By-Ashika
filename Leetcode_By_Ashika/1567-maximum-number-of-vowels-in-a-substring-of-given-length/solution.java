class Solution {
    public int maxVowels(String s, int k) {

        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
//         int maxCount = 0;

//         for (int i = 0; i <= s.length() - k; i++) {
//             int count = 0;
//             for (int j = i; j < i + k; j++) {
//                 if (vowels.contains(s.charAt(j))) {
//                     count++;
//                 }
//             }
//             maxCount = Math.max(maxCount, count);
//         }

//         return maxCount;

        int maxCount=0; int currCount=0;
        
        for (int i = 0; i < k; i++) {
            if(vowels.contains(s.charAt(i))){
                currCount++;
            }
            
        }
        
        maxCount=currCount;
        
        for (int i = k; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))){
                currCount++;
            }
            if(vowels.contains(s.charAt(i-k))){
                currCount--;
            }
            maxCount=Math.max(currCount,maxCount);
        }
        return maxCount;
        
    }
}
