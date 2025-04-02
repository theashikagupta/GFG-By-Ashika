class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums); 
        int n=nums.length; 
        int ans=nums[0];
         int freq=1;
         for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                freq++; // Increase frequency
            } else {
                freq = 1;
                 ans = nums[i]; // Reset frequency for new number
            }
            
            if (freq > n/2) { 
                return ans;
               
            }
        }
        
        // Since the majority element always exists, we return ans directly.
        return ans;
    }
}
