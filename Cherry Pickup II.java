class Solution {
    public int cherryPickup(int[][] grid) {
        int dp[][][] = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] matrix: dp){
            for(int []row: matrix){
                Arrays.fill(row, -1);
            }
        }
        return f(0, 0, grid[0].length-1, grid, dp);
    }

    public int f(int i, int j1, int j2, int[][] grid, int[][][] dp){
        if(j1 < 0 || j1 >= grid[0].length) return (int)-1e8;
        if(j2 < 0 || j2 >= grid[0].length) return (int)-1e8;
        if(i == grid.length-1){
            if(j1 != j2) return dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
            else return dp[i][j1][j2] = grid[i][j1];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int c9 = 0;
        if(j1 == j2){
            int c1 = grid[i][j1] + f(i+1,j1-1,j2-1,grid, dp);
            int c2 = Math.max(grid[i][j1] + f(i+1, j1-1,j2,grid, dp),c1);
            int c3 = Math.max(grid[i][j1] + f(i+1, j1-1, j2+1,grid, dp),c2);
            int c4 = Math.max(grid[i][j1] + f(i+1,j1,j2-1,grid, dp),c3);
            int c5 = Math.max(grid[i][j1] + f(i+1, j1, j2,grid, dp),c4);
            int c6 = Math.max(grid[i][j1] + f(i+1, j1, j2+1,grid, dp),c5);
            int c7 = Math.max(grid[i][j1] + f(i+1,j1+1, j2-1,grid, dp),c6);
            int c8 = Math.max(grid[i][j1] + f(i+1, j1+1, j2,grid, dp),c7);
            c9 = Math.max(grid[i][j1] + f(i+1, j1+1, j2+1,grid, dp),c8);
        }else{
            int c1 = grid[i][j1] + grid[i][j2] + f(i+1,j1-1,j2-1,grid, dp);
            int c2 = Math.max(grid[i][j1] + grid[i][j2] + f(i+1, j1-1,j2,grid, dp),c1);
            int c3 = Math.max(grid[i][j1] + grid[i][j2] + f(i+1, j1-1, j2+1,grid, dp),c2);
            int c4 = Math.max(grid[i][j1] + grid[i][j2] + f(i+1,j1,j2-1,grid, dp),c3);
            int c5 = Math.max(grid[i][j1] + grid[i][j2] + f(i+1, j1, j2,grid, dp),c4);
            int c6 = Math.max(grid[i][j1] + grid[i][j2] + f(i+1, j1, j2+1,grid, dp),c5);
            int c7 = Math.max(grid[i][j1] + grid[i][j2] + f(i+1,j1+1, j2-1,grid, dp),c6);
            int c8 = Math.max(grid[i][j1] + grid[i][j2] + f(i+1, j1+1, j2,grid, dp),c7);
            c9 = Math.max(grid[i][j1] + grid[i][j2] + f(i+1, j1+1, j2+1,grid, dp),c8);
        }
        return dp[i][j1][j2] = c9;
        
    }
}
