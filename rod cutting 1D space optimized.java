import java.util.*;
import java.math.*;

public class Solution {
	public static int cutRod(int price[], int n) {
		// Write your code here.

		int[] prev = new int[n+1];

		for(int i = 0;i<n+1;i++){
			prev[i] = i*price[0];
		}

		for(int ind = 1;ind<n;ind++){
			for(int N = 0;N<=n;N++){
				int rod_len = ind+1;
				int not_take = prev[N];
				int take = (int) -1e9;
				if(rod_len <= N) take = prev[N-rod_len] + price[ind];
				prev[N] = Math.max(take,not_take);
			}
		}

		return prev[n];
	}
}
