class Solution {
    public int countVowelStrings(int n) {
        String[] arr = {"a","e","i","o","u"};
        int[][] dp = new int[5][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return f(4,n,arr,dp);
    }

    public int f(int ind, int n, String[] arr, int[][] dp){
        if(ind == 0) return 1;
        if(n == 0) return 1;

        if(dp[ind][n] != -1) return dp[ind][n];

        int take = f(ind, n-1, arr,dp);
        int not_take = f(ind-1, n, arr,dp);

        return dp[ind][n] = take + not_take;
    }
}
