class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0;i<m;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int level = 1;level<n;level++){
            for(int i = 0;i<m;i++){
                if(i == 0) dp[level][i] = Math.min(dp[level-1][0] + matrix[level][i], dp[level-1][1]+matrix[level][i]);
                else if(i == m-1) dp[level][i] = Math.min(dp[level-1][i] + matrix[level][i], matrix[level][i]+dp[level-1][i-1]);
                else{
                    dp[level][i] = matrix[level][i] + Math.min(dp[level-1][i-1], Math.min(dp[level-1][i], dp[level-1][i+1]));
                }
            }
        }
        int ret = (int)1e8;
        for(int i=0;i<m;i++){
            ret = Math.min(ret, dp[n-1][i]);
        }
        return ret;
           
    }
}
