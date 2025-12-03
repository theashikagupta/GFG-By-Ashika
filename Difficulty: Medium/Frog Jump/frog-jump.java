class Solution {
    int minCost(int[] height) {
        // code here
        
        return solve(height);
    }
    int solve(int[] h){
        int n=h.length;
        int[] dp=new int[n];
        if(n==1 || n==0) return 0;
        dp[0]=0;
        dp[1]=Math.abs(h[1]-h[0]);
        for(int i=2;i<n;i++){
            int oneStep=dp[i-1]+ Math.abs(h[i]-h[i-1]);
            int twoStep=dp[i-2] + Math.abs(h[i]-h[i-2]);
            dp[i]=Math.min(oneStep,twoStep);
        }
        return dp[n-1];
    }
}