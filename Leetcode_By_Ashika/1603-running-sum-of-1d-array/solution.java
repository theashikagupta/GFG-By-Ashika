class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int[] new_arr=new int[n];
        new_arr[0]=nums[0];
        for(int i=1; i<n; i++){
            new_arr[i]=new_arr[i-1]+nums[i];

        }return new_arr;
    }
}
