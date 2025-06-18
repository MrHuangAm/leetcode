/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        // dp[i] 表示和为 i 的完全平方数的最少数量
        int[] dp = new int[n + 1];
        // 初始化 dp 数组，将所有元素初始化为最大值
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // 0 不需要任何完全平方数相加
        dp[0] = 0;

        // 遍历 1 到 n 的每个数
        for (int i = 1; i <= n; i++) {
            // 遍历所有小于等于 i 的完全平方数
            for (int j = 1; j * j <= i; j++) {
                // 状态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
// @lc code=end

