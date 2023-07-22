import java.util.*;
import java.math.*;

public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.

		int[][] dp = new int[n][n+1];

		for(int i = 0;i<n+1;i++){
			dp[0][i] = i*price[0];
		}

		for(int ind = 1;ind<n;ind++){
			for(int N = 0;N<=n;N++){
				int rod_len = ind+1;
				int not_take = dp[ind-1][N];
				int take = (int) -1e9;
				if(rod_len <= N) take = dp[ind][N-rod_len] + price[ind];
				dp[ind][N] = Math.max(take,not_take);
			}
		}

		return dp[n-1][n];
	}
}
