class Solution {
    public int coinChange(int[] coins, int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];

        int INF = Integer.MAX_VALUE - 1;

        // 0 coins se koi positive sum nahi ban sakta
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = INF;
        }

        // Sum = 0 ke liye 0 coins chahiye
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(
                            1 + dp[i][j - coins[i - 1]],
                            dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum] == INF ? -1 : dp[n][sum];
    }
}