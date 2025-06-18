/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        int n = prices.length;
        // 当 k 大于等于数组长度的一半时，相当于可以进行无限次交易
        if (k >= n / 2) {
            return maxProfitInf(prices);
        }
        // 初始化 buy 和 sell 数组
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        for (int j = 1; j <= k; j++) {
            buy[j] = -prices[0];
        }

        // 状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // 第 j 次买入的最大利润
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                // 第 j 次卖出的最大利润
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return sell[k];
    }

    // 处理可以进行无限次交易的情况
    private int maxProfitInf(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
// @lc code=end

