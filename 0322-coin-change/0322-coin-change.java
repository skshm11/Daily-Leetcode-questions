class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int[] row : dp) Arrays.fill(row, -1);
        int ans = helper(n - 1, amount, coins, dp);
        return ans == (int) Math.pow(10, 9) ? -1 : ans; 
    }

    private int helper(int i, int t, int[] coins, int[][] dp){
        //base case
        if(t == 0) return 0;
        if(i == 0){
            if(t % coins[i] == 0) return t/coins[i];
            else{
            return (int) Math.pow(10, 9);
        }
        }

        if(dp[i][t] != -1) return dp[i][t];
        
        int notTaken = helper(i-1, t, coins, dp);
        
        int taken = (int) Math.pow(10, 9); // why??
        
        if(coins[i] <= t){
            taken = 1 + helper(i,t-coins[i],coins, dp);
        }

        return dp[i][t] = Math.min(notTaken, taken);    
    }
}
