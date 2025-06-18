/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
        int[] dp = new int[n];
        // 初始化每个元素的最长递增子序列长度为 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[i] < nums[j]){
                    dp[j] = Math.max(dp[i]+1,dp[j]);
                }
            }
            // 更新全局最长长度
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
// @lc code=end

