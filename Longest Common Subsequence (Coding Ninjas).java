import java.util.*;
public class Solution {

	public static int lcs(String s, String t) {
		int n = s.length();
		int m = t.length();
		int[][] dp = new int[n+1][m+1];

		for(int i1 = 1;i1<=n;i1++){
			for(int i2 = 1;i2<=m;i2++){
				if(s.charAt(i1-1) == t.charAt(i2-1)) dp[i1][i2] = 1 + dp[i1-1][i2-1];
				else{
					dp[i1][i2] = Math.max(dp[i1-1][i2],dp[i1][i2-1]);
				}
			}
		}

		return dp[n][m];
    }

}
