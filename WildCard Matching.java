class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[m][n];

        for(int[] row: dp) Arrays.fill(row,-1);

        return f(m-1,n-1,p,s,dp);
    }

    public boolean f(int i, int j, String s, String t, int[][] dp){

        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(j < 0 && i >= 0){
            for(int k = 0;k<=i;k++){
                if(s.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != -1){
            if(dp[i][j] == 0) return false;
            else return true;
        }

        if(s.charAt(i) == t.charAt(j) || s.charAt(i) == '?') {
            dp[i][j] = f(i-1,j-1,s,t,dp) ? 1:0;
            return f(i-1,j-1,s,t,dp);
        }

        if(s.charAt(i) == '*'){
            dp[i][j] = f(i-1,j,s,t,dp) || f(i,j-1,s,t,dp) ? 1:0;
            return f(i-1,j,s,t,dp) || f(i,j-1,s,t,dp);
        }

        dp[i][j] = 0;
        return false;
    }
}
