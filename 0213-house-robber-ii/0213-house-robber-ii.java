class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // List<Integer> l1 = new ArrayList<>();
        // List<Integer> l2 = new ArrayList<>();
        int[] l1 = new int[n];
        int[] l2 = new int[n];

        if(nums.length==1)return nums[0];

        for(int i= 0; i< n;i++){       
            if(i!=0) l1[i] = nums[i];
            if(i!= n - 1) l2[i] = nums[i];
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        return Math.max(robHelper(l1, n-1,dp1), robHelper(l2, n-1,dp2));
    }

    public int robHelper(int[] nums, int ind, int[] dp){
        if(ind == 0) return nums[0];

        if(ind < 0) return 0;
        
        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + robHelper(nums, ind - 2, dp);
        int notPick = 0 + robHelper(nums, ind - 1, dp);

        return dp[ind] = Math.max(pick, notPick);
    }
}