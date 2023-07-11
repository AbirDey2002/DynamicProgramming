import java.util.* ;
import java.io.*; 
import java.math.*;
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return f(k, n-1, arr, dp);
    }

    public static boolean f(int target, int index, int[] arr, int[][] dp){
        if(target == 0){
            dp[index][target] = 1;
            return true;
        } 
        if(index == 0){
            dp[index][target] = (target == arr[index]) ? 1: 0;
            return (target == arr[index]);
        } 

        if(dp[index][target] != -1){
            if(dp[index][target] == 0) return false;
            else return true;
        }

        boolean not_take = f(target, index-1, arr, dp);
        boolean take = false;
        if(target >= arr[index]){
            take = f(target-arr[index], index-1, arr, dp);
        }
        
        dp[index][target] = (take || not_take) ? 1: 0;
        return (take || not_take);
    }
}
