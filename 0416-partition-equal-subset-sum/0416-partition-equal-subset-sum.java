class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum+= num;
        }

        if(sum % 2 != 0) return false;

        int n = nums.length, target = sum/2;
        int[][] dp = new int[n][target+1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(n-1,target,nums, dp);
    }

    private boolean helper(int i, int target, int[] nums, int[][] dp){
        // base condition
        if(target == 0) return true;
        
        if(i == 0) return (nums[i] == target);

        if(dp[i][target] != -1) return dp[i][target] == 0 ? false: true;

        // Do stuff on all the possible subsets/subsequences
        boolean notTaken = helper(i - 1, target, nums, dp);

        boolean taken = false;

        if(nums[i] <= target){
            taken = helper(i-1, target - nums[i], nums, dp);
        }

        dp[i][target] = notTaken || taken ? 1 : 0;
        
        return notTaken || taken;
    }
}