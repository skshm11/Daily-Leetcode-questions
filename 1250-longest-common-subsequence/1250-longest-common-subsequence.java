class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        return helper(text1.length() - 1, text2.length() -1, text1, text2, dp);
    }

    private int helper(int i1, int i2, String s1, String s2, int[][] dp){
        if(i1 < 0 || i2 < 0) return 0;
        
        if(dp[i1][i2] != -1) return dp[i1][i2];

        // condition if the character matches
        if(s1.charAt(i1) == (s2.charAt(i2))){
            return dp[i1][i2] = 1 + helper(i1 - 1, i2 -1, s1, s2,dp);
        }else{
        // If the characters are different, choose the maximum LCS length by either
        // skipping a character in s1 or skipping a character in s2
            return dp[i1][i2] = 0 + Math.max(helper(i1-1,i2,s1,s2,dp), helper(i1, i2 -1, s1, s2,dp));
        }
    }
}