/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 创建 dp 数组用于存储最小路径和
        int[][] dp = new int[m][n];

        // 初始化起点的最小路径和
        dp[0][0] = grid[0][0];

        // 初始化第一行的最小路径和
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 初始化第一列的最小路径和
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 填充 dp 数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // 返回右下角的最小路径和
        return dp[m - 1][n - 1];
    }
}
// @lc code=end

