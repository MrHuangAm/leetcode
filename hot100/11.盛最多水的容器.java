/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        // 初始化左右指针
        int left = 0;
        int right = height.length - 1;
        // 初始化最大容量
        int maxArea = 0;

        while (left < right) {
            // 计算当前容量
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // 更新最大容量
            maxArea = Math.max(maxArea, currentArea);

            // 移动较短的垂线对应的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
// @lc code=end

