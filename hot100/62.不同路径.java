/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        // 创建二维数组 dp 用于存储不同位置的路径数量
        int[][] dp = new int[m][n];
        // 初始化第一行，因为从左上角到第一行的每个位置只有一种走法
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 初始化第一列，因为从左上角到第一列的每个位置只有一种走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 填充 dp 数组，根据状态转移方程计算每个位置的路径数量
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 右下角位置的路径数量即为结果
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

