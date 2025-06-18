/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 若数组为空，直接返回 0
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 记录到当前位置为止的最低股票价格，初始化为数组第一个元素
        int minPrice = prices[0];
        // 记录最大利润，初始化为 0
        int maxProfit = 0;
        // 遍历数组
        for (int i = 1; i < prices.length; i++) {
            // 更新最低股票价格
            minPrice = Math.min(minPrice, prices[i]);
            // 计算以当前价格卖出时的利润
            int profit = prices[i] - minPrice;
            // 更新最大利润
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
// @lc code=end

