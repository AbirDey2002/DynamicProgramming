class Solution {
    public int maxProfit(int[] prices) {
        int[] ahead = new int[2], curr = new int[2];

        int n = prices.length;
        ahead[0] = 0; ahead[1] = 0;

        for(int i = n-1;i>=0;i--){
            for(int buy = 0;buy<=1;buy++){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[i] + ahead[0],ahead[1]);
                }else{
                    profit = Math.max(prices[i] + ahead[1],ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }

        return ahead[1];
    }
}
