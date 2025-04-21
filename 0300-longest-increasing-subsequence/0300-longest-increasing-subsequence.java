class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(0,-1,nums,dp);
    }

    public int helper(int ind, int prev, int[] nums, int[][] dp){
        
        if(ind == nums.length) return 0;
        
        // co-ordinate shift because you can't store -1 but you can store
        // n + 1 index in dp array as -1 can not be an index. 
        if(dp[ind][prev + 1] != -1) return dp[ind][prev + 1];

        int notTake = helper(ind+1, prev, nums, dp);
        int take = 0;

        if(prev == -1 || nums[ind] > nums[prev])
        take = 1 + helper(ind + 1, ind, nums, dp);

        return dp[ind][prev + 1] = Math.max(take, notTake);
    }
}