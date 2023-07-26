class Solution {
    public int maxProfit(int[] prices) {
        int minimum = prices[0];
        int profit = 0;
        for(int i = 1;i<prices.length;i++){
            profit = Math.max(profit, prices[i] - minimum);
            minimum = Math.min(minimum, prices[i]);
        }
        return profit;
    }
}
