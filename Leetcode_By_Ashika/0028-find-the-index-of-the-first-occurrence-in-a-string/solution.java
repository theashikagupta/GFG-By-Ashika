class Solution {
    public int strStr(String haystack, String needle) {
        //Naive algorithm
//         for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//         int j;
//             for (j = 0; j < needle.length(); j++) {
//                if (haystack.charAt(i + j) != needle.charAt(j)) break;
//             }
//         if (j == needle.length()) {
//             return i;
//         }
// }
//  return -1;


       //Knuth-Morris-Pratt algorihtm
        //     int n=haystack.length();
        //     int m=needle.length();
        //     int[] lps=pitable(needle);
        //     int j=0; int i=0;
        //     while(i<n){
        //         if(haystack.charAt(i)==needle.charAt(j)){
        //             i++;
        //             j++;
        //             if(j==m){
        //                 return i-j;
                        
        //             }
                
        //         }else{
        //             if(j!=0){
        //                 j=lps[j-1];
        //             }else{
        //                 i++;
        //             }
        //         }
        //     }
        //     return -1;
        // }
        // public int[] pitable(String needle){

        //     int[] lps=new int [needle.length()];
        //     int len=0;
        //     int i=1;

        //     while(i<needle.length()){
        //         if(needle.charAt(i)==needle.charAt(len)){
        //             len++ ;
        //             lps[i]=len;
        //             i++;
        //         }
        //         else{
        //             if(len!=0){
        //                 len=lps[len-1];
        //             } else{
        //                 lps[i]=0;
        //                 i++;
        //             }
        //         }
        //     }
        //     return lps;
        // }
       
       //Rabin-Karp algorithm

         int n = haystack.length();
        int m = needle.length();
        if (m > n) return -1;
        if (m == 0) return 0;

        int base = 256;       // Base for ASCII characters
        int mod = 101;        // A prime number for modulo to reduce collision

        // Precompute (base^(m-1)) % mod
        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % mod;
        }

        // Calculate hash of pattern and first window
        int patternHash = 0, textHash = 0;
        for (int i = 0; i < m; i++) {
            patternHash = (base * patternHash + needle.charAt(i)) % mod;
            textHash = (base * textHash + haystack.charAt(i)) % mod;
        }

        // Slide the window over haystack
        for (int i = 0; i <= n - m; i++) {
            // Check hash values
            if (patternHash == textHash) {
                // Double check by comparing characters
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) return i;
            }

            // Calculate hash for next window
            if (i < n - m) {
                textHash = (base * (textHash - haystack.charAt(i) * h) + haystack.charAt(i + m)) % mod;

                // Make sure hash is positive
                if (textHash < 0) {
                    textHash += mod;
                }
            }
        }

        return -1;
    }
    
}

