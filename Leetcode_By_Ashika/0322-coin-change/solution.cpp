class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int n=coins.size();
        vector<vector<int>>dp(n,vector<int>(amount+1,amount+1));
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
        }
        for(int idx=1;idx<n;idx++){
            for(int T=0;T<=amount;T++){
                int nottake=0+dp[idx-1][T];
                int take=INT_MAX;
                if(T>=coins[idx]) take=1+dp[idx][T-coins[idx]];
                dp[idx][T]=min(nottake,take);
            }
        }
        if(dp[n-1][amount]==amount+1){
            return -1;
        }
        return dp[n-1][amount];    
    }
};
