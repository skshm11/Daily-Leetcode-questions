class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robHelper(nums, n - 1, dp);
    }

    private int robHelper(int[] nums, int ind, int[] dp){
        if(ind == 0) return nums[0];

        if(ind < 0) return 0;
        
        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + robHelper(nums, ind - 2, dp);
        int notPick = 0 + robHelper(nums, ind - 1, dp);

        return dp[ind] = Math.max(pick, notPick);
    }
}