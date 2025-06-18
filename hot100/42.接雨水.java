/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] leftbound = new int[len];
        int leftMax = height[0];
        int ans= 0;
        for(int i=1;i<len;i++){
            leftbound[i] = leftMax;
            if(height[i]>leftMax){
                leftMax = height[i];
            }
        }
        int rightMax = height[len-1];
        for(int i=len-2;i>0;i--){
            //需要大于才能加，不然还会倒扣
            if(Math.min(rightMax, leftbound[i]) > height[i])
            ans += Math.min(rightMax, leftbound[i]) - height[i];
            if(height[i]>rightMax){
                rightMax = height[i];
            }
        }
        return ans;

    }
}
// @lc code=end

