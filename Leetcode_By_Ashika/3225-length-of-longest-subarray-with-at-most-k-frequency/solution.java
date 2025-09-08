class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        
        for(int right=0; right<n; right++){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.get(nums[right]) > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                
                left++;
                

            }
            maxLen=Math.max(maxLen,right-left+1);
            
            
        }
        return maxLen;
    }
}
