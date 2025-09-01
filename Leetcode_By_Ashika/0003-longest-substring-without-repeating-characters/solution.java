import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;



    // int n=s.length();
    // int maxLen=0;
    // for(int i=0;i<n;i++){
    //     for(int j=i;j<n;j++){
    //         if (allUnique(s,i,j)){
    //             maxLen = Math.max(maxLen,j - i + 1);
    //         }
            
    //     }
       
    // } return maxLen;
    // }
    //  public static boolean allUnique(String s,int start,int end){
    //     HashSet<Character> substr=new HashSet<>();
    //     for(int i=start;i<=end;i++ ){
              
    //           if(substr.contains(s.charAt(i))){
    //             return false;
    //           }
    //           substr.add(s.charAt(i));
    //     }
    //     return true;
    
    }
  
}

