class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(n - 1, amount, coins, dp);
    }

    private int helper(int i, int t, int[] coins, int[][] dp){
        //base case
        if(i == 0){
        if(t % coins[i] == 0) {
            return 1;
        }else{
            return 0;
        }
    }
        if(dp[i][t] != -1) return dp[i][t];
        
        int notTaken = helper(i - 1, t, coins, dp);

        int taken = 0;
        if(coins[i] <= t){
            taken = helper(i, t - coins[i], coins, dp);
        }

        return dp[i][t] = taken + notTaken;
    }
}