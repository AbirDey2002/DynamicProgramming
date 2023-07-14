import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findWays(int num[], int tar) {
        int n = num.length;
        return f(n-1,tar, num);
    }

    public static int f(int ind, int sum, int[] num){
        if(sum == 0) return 1;
        if(ind == 0) return (num[0] == sum)?1:0;

        int not_pick = f(ind-1,sum,num);
        int pick = 0;
        if(sum >= num[ind]){
            pick = f(ind-1,sum-num[ind],num);
        }

        return pick + not_pick;
    }
}
