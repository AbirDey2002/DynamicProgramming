import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n = num.length;
        int [][]dp = new int[n][x+1];
        for(int[] row: dp) Arrays.fill(row, 0);

        for(int T = 0;T<= x; T++){
            if(T%num[0] == 0) dp[0][T] = T/num[0];
            else dp[0][T] = (int) 1e9;
        }

        for(int i = 1;i<n;i++){
            for(int T = 0;T<= x;T++){
                int not_take = dp[i-1][T];
                int take = (int)1e9;
                if(T >= num[i]) take = 1 + dp[i][T-num[i]];
                dp[i][T] = Math.min(take,not_take);
            }            
        }

        int ans = dp[n-1][x];
        if(ans >= (int)1e9) return -1;
        return ans;
    }

}
