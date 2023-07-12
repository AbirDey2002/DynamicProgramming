import java.util.*;

public class Solution {
	public static boolean canPartition(int[] arr, int n) {
		int sum = 0;
		for(int i: arr) sum += i;
		if(sum%2 != 0) return false;
		int target = sum/2;
		int[][] dp = new int[n+1][target+1];
		for(int[] row: dp) Arrays.fill(row, -1);
		return f(n-1,sum/2,arr, dp);
	}

	public static boolean f(int ind, int target, int arr[], int[][] dp){
		
		if(ind == 0) return (target == arr[ind]);
		if(target == 0) return true;

		if(dp[ind][target] != -1){
			if(dp[ind][target] == 1)return true;
			else return false;
		}

		boolean take = false;
		if(target >= arr[ind]){
			take = f(ind-1,target-arr[ind],arr, dp);
		}
		boolean not_take = f(ind-1,target,arr, dp);

		dp[ind][target] = (take || not_take)?1:0;
		return take||not_take;
	}
}
