/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        // 处理数组为空或只有一个元素的情况
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        // 创建 dp 数组
        int[] dp = new int[n];
        // 初始化 dp[0] 和 dp[1]
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 根据状态转移方程填充 dp 数组
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        // 返回抢劫前 n 间房屋的最大金额
        return dp[n - 1];
    }
}
// @lc code=end

