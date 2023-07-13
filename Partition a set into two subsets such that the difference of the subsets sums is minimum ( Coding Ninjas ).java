import java.util.* ;
import java.io.*; 
import java.math.*;

public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
		int totalSum = 0;
		for(int i: arr) totalSum += i;

		int k = totalSum;

		boolean dp[][] = new boolean[n][totalSum+1];

		for(int i = 0;i<n;i++) dp[i][0] = true;
		if(arr[0] <= k) dp[0][arr[0]] = true;

		for(int i = 1;i<n;i++){
			for(int target = 1;target<=k;target++){
				boolean not_take = dp[i-1][target];
				boolean take = false;
				if(target >= arr[i]) take = dp[i-1][target-arr[i]];
				dp[i][target] = take || not_take;
			}
		}

		int min = (int)1e9;
		for(int s1 = 0;s1<=totalSum/2;s1++){
			if(dp[n-1][s1] == true){
				min = Math.min(min, Math.abs(totalSum - 2*s1));
			}
		}

		return min;
	}
}
