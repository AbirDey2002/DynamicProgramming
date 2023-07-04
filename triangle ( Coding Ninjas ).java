public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        int m = triangle.length;
        int l = triangle[m-1].length;
        int[][] dp = new int[m][l];
        for(int[] row: dp) Arrays.fill(row, -1);
        return (int)f(0,0,triangle, dp);
    }

    public static long f(int i, int j, int[][] triangle, int[][] dp){
        if(i == triangle.length-1) return (long)triangle[i][j];
        if(j > i) return (long)Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];

        long down = (long)triangle[i][j] + f(i+1,j,triangle,dp);
        long dia = (long)triangle[i][j] + f(i+1,j+1,triangle, dp);

        return dp[i][j] = (int)Math.min(down, dia);
    }
}
