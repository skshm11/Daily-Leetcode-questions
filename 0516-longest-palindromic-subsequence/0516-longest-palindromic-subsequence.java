class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s); 
        String reversed = sb.reverse().toString();
        int l1 = s.length(), l2 = reversed.length();

        int[][] dp = new int[l1][l2];
        for(int[] row : dp){
        Arrays.fill(row, -1);
        }

        return helper(l1 - 1, l2 -1,s, reversed, dp);
    }

    private int helper(int i1, int i2, String s1, String s2, int[][]dp){
        if(i1 < 0 || i2 < 0) return 0;

        if(dp[i1][i2] != -1) return dp[i1][i2];
        if(s1.charAt(i1) == s2.charAt(i2)){
            return dp[i1][i2] = 1 + helper(i1 - 1, i2 - 1, s1, s2, dp);
        }else{
            return dp[i1][i2] = Math.max(helper(i1-1, i2, s1, s2,dp), helper(i1, i2-1,s1,s2,dp));
        }
    }
    
}

// public static String reverseWithCharArray(String s) {
//     char[] chars = s.toCharArray();
//     int left = 0, right = chars.length - 1;
//     while (left < right) {
//         char temp = chars[left];
//         chars[left++] = chars[right];
//         chars[right--] = temp;
//     }
//     return new String(chars);
// }