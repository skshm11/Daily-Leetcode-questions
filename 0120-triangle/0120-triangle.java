class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // memoisation to reduce the time complexity
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return helper(0,0,triangle,dp);
    }

    private int helper(int i, int j, List<List<Integer>> triangle, int[][] dp){
        //base case
        if(i == triangle.size() - 1) return triangle.get(i).get(j);

        // Fetch the value already calculated from dp array to curb the overlapping problems
        if(dp[i][j] != -1) return dp[i][j];
        
        //do some stuff on the possible paths
        int down = triangle.get(i).get(j) + helper(i+1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + helper(i+1, j+1, triangle, dp);
        
        // return the min of all the possible paths
        return dp[i][j] = Math.min(down, diagonal);
    }
}