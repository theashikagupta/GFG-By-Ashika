class Solution {
    public void sortColors(int[] nums) {
    //Dutch Play Algorithm
        int n=nums.length;
        int i=0;
        int j=n-1;
        int k=0;
        while(k<=j){
            if(nums[k]==0){
                swap(nums,i,k);
                i++;
                k++;
            }
            else if(nums[k]==2){
                swap(nums,j,k);
                j--;
                
            }else{
                k++;
            }
        }
    }public void swap(int[] nums, int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
