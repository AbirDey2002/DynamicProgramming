import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int n = num.length;
        int [][]dp = new int[n][x+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        int ans = f(n-1,x,num, dp);
        if(ans >= (int)1e9) return -1;
        return ans;
    }

    public static int f(int i, int T, int[] arr, int[][] dp){
        if(i == 0){
            if(T%arr[0] == 0) return T/arr[0];
            else return (int) 1e9;
        }

        if(dp[i][T] != -1) return dp[i][T];

        int not_take = 0 + f(i-1,T,arr, dp);
        int take = (int)1e9;
        if(T>=arr[i]) take = 1 + f(i, T-arr[i],arr, dp);

        return dp[i][T] = Math.min(take, not_take);
    }

}
