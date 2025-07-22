class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int arr1[]=new int[set.size()];
        int i=0;
        for(int num:set){
            arr1[i]=num;
            i++;
        }
        Arrays.sort(arr1);
        return lcs(nums,arr1);
        
    }

    static int lcs(int nums[],int arr1[]){
        int n=nums.length;
        int m=arr1.length;
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(n==0||m==0){
                    dp[i][j]=0;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums[i-1]==arr1[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
               
        }
      
       return dp[n][m];
    }
}

