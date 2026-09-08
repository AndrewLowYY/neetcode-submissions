class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 0;
    
        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
                continue;
            }

            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);

            right++;
        }
        return maxProfit;
    }
}
