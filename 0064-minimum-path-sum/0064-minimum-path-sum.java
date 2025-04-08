class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return helper(m-1,n-1,grid,dp);
    }

    public int helper(int i, int j, int[][] grid, int[][] dp){
        // base conditions
        if(i == 0 && j == 0) return grid[i][j];

        if(i < 0 || j < 0) return (int) Math.pow(10, 9);

        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + helper(i-1, j, grid, dp);
        int left = grid[i][j] + helper(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up, left);
    }
}