/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0;
        int maxNum = 0;
        // 计算数组总和以及最大值
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        // 若总和为奇数，无法分割
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 若最大值大于目标和，无法分割
        if (maxNum > target) {
            return false;
        }
        // 定义 dp 数组
        // 实际上是01背包问题，dp方程表示的是，考虑前i个物品，是否存在和为j的背包
        boolean[][] dp = new boolean[n + 1][target + 1];
        // 初始化
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                //如果只考虑前i-1个物品就存在和为j的物品，那么考虑前i个肯定也存在
                dp[i][j] = dp[i - 1][j]; 
                if (j >= num) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num];
                }
            }
        }
        return dp[n][target];
    }
}
// @lc code=end

