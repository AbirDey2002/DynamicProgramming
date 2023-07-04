import java.util.*;

public class Solution {
    public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return f(n-1, m-1, mat, dp);
    }

    public static int f(int i, int j, ArrayList<ArrayList<Integer>> mat, int[][] dp){
        
        if(i>= 0 && j >=0 && mat.get(i).get(j) == -1) return 0;
        if(i == 0 && j == 0) return 1;
        if(i <0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int mod = 1000000007;

        int left = f(i, j-1, mat, dp);
        int up = f(i-1, j, mat, dp);
        return dp[i][j] = (up + left)%mod;
    }

}
