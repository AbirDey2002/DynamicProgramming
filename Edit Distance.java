class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        //memoization table
        int dp[][] = new int[n][m];
        for(int[] row: dp) Arrays.fill(row,-1);

        //recursive call
        return f(n-1,m-1,word1,word2,dp);
    }

    public int f(int i, int j, String s, String t, int[][] dp){
        
        // base cases
        if(i < 0 || j < 0){
            if(i < 0){
                return j+1;
            }else{
                return i+1;
            }
        }

        if(dp[i][j] != -1) return dp[i][j];

        // String match case
        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = f(i-1,j-1,s,t,dp);


        // String do not match case
        int insert = 1 + f(i,j-1,s,t,dp);
        int delete = 1 + f(i-1,j,s,t,dp);
        int replace = 1 + f(i-1,j-1,s,t,dp);

        return dp[i][j] = Math.min(Math.min(insert,delete),replace);
    }
}
