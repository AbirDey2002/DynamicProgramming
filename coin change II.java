class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i = 0;i<n;i++){
            dp[i][0] = 1;
        }

        for(int T = 0;T<=amount;T++){
            if(T%coins[0] == 0) dp[0][T] = 1;
            else dp[0][T] = 0;
        }

        for(int i = 1;i<n;i++){
            for(int T = 0;T<=amount;T++){
                int not_pick = dp[i-1][T];
                int pick = 0;
                if(T >= coins[i]) pick = dp[i][T-coins[i]];
                dp[i][T] = pick + not_pick;
            }
        }

        return dp[n-1][amount];
    }
}
