class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(m-1, n-1, word1, word2, dp);
    }

    private int helper(int i1, int i2, String s1, String s2, int[][] dp){
        // base condition
        if(i1 < 0) return i2 + 1;
        if(i2 < 0) return i1 + 1; 

        if(dp[i1][i2] != -1) return dp[i1][i2];

        // recursion
        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = helper(i1-1, i2-1, s1, s2, dp);
        }else{
            // three possibilities -> insert, delete, replace in this order
            return dp[i1][i2] = Math.min(1 + helper(i1, i2-1, s1,s2, dp), 
            Math.min(1 + helper(i1 - 1, i2, s1,s2, dp), 1 + helper(i1-1, i2-1, s1,s2, dp)));
        }
    }
}