class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;        
        long[][] dp = new long[m][n];
        for(long[] row: dp) {       
            Arrays.fill(row, -1);
        }
        return (int)helper(m-1,n-1,grid,dp);
    }

    public long helper(int i, int j, int[][] grid, long[][] dp){
        if(i == 0 && j == 0) return (long)grid[i][j];
        if(i < 0 || j < 0) return (long)Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        long left = helper(i, j-1, grid, dp) + (long)grid[i][j];
        long up = helper(i-1, j, grid, dp) + (long)grid[i][j];

        return dp[i][j] = Math.min(left,up);
    }
}
