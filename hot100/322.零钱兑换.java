/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 创建 dp 数组，dp[i] 表示凑成金额 i 所需的最少硬币数量
        int[] dp = new int[amount + 1];
        // 初始化 dp 数组，将除 dp[0] 外的元素初始化为一个较大的值
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        // 凑成金额 0 不需要任何硬币
        dp[0] = 0;

        // 遍历每个金额
        for (int i = 1; i <= amount; i++) {
            // 遍历每种硬币面额
            for (int coin : coins) {
                if (i >= coin) {
                    // 状态转移方程
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果 dp[amount] 仍为初始值，说明无法凑出该金额
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end

