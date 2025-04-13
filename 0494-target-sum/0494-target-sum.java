class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        
        // calculate total sum
        for(int num : nums){
            sum += num;
        }

        if(sum-target < 0) return 0;
        if((sum-target) % 2 != 0) return 0;

        int s2 = (sum-target)/2;
        int[][] dp = new int[n][s2+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return helper(n-1,s2,nums, dp);
    }

    private int helper(int i, int t, int[] nums, int[][] dp){
        //base condition
        if(i == 0){
            if (t == 0 && nums[0] == 0)
                return 2;
            // Check if the target is equal to the first element or 0
            if (t == 0 || t == nums[0])
                return 1;
            return 0;
        }

        if(dp[i][t] != -1) return dp[i][t];
        int notTaken = helper(i-1, t, nums, dp);
        int taken = 0;

        if(nums[i] <= t){
            taken = helper(i-1,t-nums[i], nums, dp);
        }

        return dp[i][t] = (taken + notTaken);
    }
}