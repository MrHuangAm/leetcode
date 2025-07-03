/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int preMax = height[0];
        for (int i = 1; i < leftMax.length; i++) {
            leftMax[i] = preMax;
            preMax = Math.max(height[i], preMax);
        }
        int area = 0;
        int rightMax = 0;
        for(int i=height.length-1;i>=0;i--){
            if(Math.min(rightMax,leftMax[i])-height[i] > 0)
                area += Math.min(rightMax,leftMax[i])-height[i];
            rightMax = Math.max(rightMax, height[i]);
        }
        return area;
    }
}
// @lc code=end

