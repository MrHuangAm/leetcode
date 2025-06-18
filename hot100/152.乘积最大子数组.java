/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 若数组为空，直接返回 0
        if (n == 0) {
            return 0;
        }
        // 初始化最大乘积结果、当前最大乘积和当前最小乘积
        int maxResult = nums[0];
        int maxCurrent = nums[0];
        int minCurrent = nums[0];

        // 从数组第二个元素开始遍历
        for (int i = 1; i < n; i++) {
            // 由于 maxCurrent 会被更新，先保存其值
            int prevMax = maxCurrent;
            // 计算当前位置的最大乘积，考虑三种情况：当前元素、当前元素乘以之前的最大乘积、当前元素乘以之前的最小乘积
            maxCurrent = Math.max(nums[i], Math.max(nums[i] * maxCurrent, nums[i] * minCurrent));
            // 计算当前位置的最小乘积，同样考虑三种情况
            minCurrent = Math.min(nums[i], Math.min(nums[i] * prevMax, nums[i] * minCurrent));
            // 更新全局最大乘积
            maxResult = Math.max(maxResult, maxCurrent);
        }
        return maxResult;
    }
}
// @lc code=end

