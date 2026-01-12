class Solution {

    static Integer[][] dp;

    static int matrixMultiplication(int arr[]) {

        int n = arr.length;

        dp = new Integer[n + 1][n + 1];

        
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n - 1; j++) {

                int min = (int) 1e9;

                for (int idx = i; idx < j; idx++) {

                    int cost =
                            arr[i - 1] * arr[idx] * arr[j]
                            + dp[i][idx]
                            + dp[idx + 1][j];

                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][n - 1];
    }
}