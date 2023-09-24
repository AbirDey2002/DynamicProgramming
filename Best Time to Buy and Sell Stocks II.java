class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return f(0,1,prices,n);
    }

    public int f(int ind, int buy, int[] arr, int n){
        if(ind == n) return 0;

        int buy_now = 0, buy_later = 0, sell_now = 0, sell_later = 0;
        
        if(buy == 1){
            buy_now = - arr[ind] + f(ind+1,0,arr,n);
            buy_later = 0 + f(ind+1,1,arr,n);
        }else{
            sell_now = arr[ind] + f(ind+1,1,arr,n);
            sell_later = f(ind+1,0,arr,n);
        }
        return Math.max(Math.max(Math.max(sell_now, sell_later),buy_now),buy_later);
    }
}
