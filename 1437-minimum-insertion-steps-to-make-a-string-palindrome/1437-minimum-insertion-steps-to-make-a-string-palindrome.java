class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();

        // Fixing overlapping intervals
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int ans = helper(n - 1, reversed.length() - 1,s, reversed, dp);
        return n - ans;
    }

    private int helper(int i1,int i2,String s1,String s2, int[][] dp){
        //base case
        if(i1 < 0 || i2 < 0) return 0;

        if(dp[i1][i2] != -1) return dp[i1][i2];
        
        //recursion
        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = 1 + helper(i1 - 1, i2 - 1, s1,s2, dp); 
        }else{
            return dp[i1][i2] = Math.max((helper(i1 - 1, i2, s1,s2, dp)), helper(i1, i2 - 1, s1,s2, dp));
        }
    }
}