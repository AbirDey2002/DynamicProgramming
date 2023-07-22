import java.util.*;
import java.math.*;

public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.

		int[][] dp = new int[n][n+1];
		for(int[] row: dp) Arrays.fill(row, -1);
		return f(price.length-1,n,price,dp);
	}

	public static int f(int ind, int n, int[] arr, int[][] dp){
		
		if(ind == 0){
			return n*arr[0];
		}

		if(dp[ind][n] != -1) return dp[ind][n];

		int rod_len = ind + 1;
		int not_take = f(ind-1,n,arr, dp);
		int take = (int)-1e9;
		if(n >= rod_len) take = arr[ind] + f(ind,n-rod_len,arr, dp);

		return dp[ind][n] = Math.max(take, not_take);
	}
}
