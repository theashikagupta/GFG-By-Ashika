class Solution {
    public int maxSubArray(int[] nums) {
        int cs=nums[0];
        int ms=nums[0];
        int n=nums.length;
        for(int i=1;i<n;i++){
            cs=Math.max(nums[i],cs+nums[i]);
            ms=Math.max(ms,cs);
        }
        return ms;

        //Bruteforce
        
        // int ms=Integer.MIN_VALUE;
        // int n=nums.length;
        // for(int i=0;i<n;i++){
        //     int cs=0;
        //     for(int j=i;j<n;j++){
        //         cs=cs+nums[j];
        //         ms=Math.max(ms,cs);
        //     }
        // }
        // return ms;

    }
}

