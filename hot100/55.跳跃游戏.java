/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;
        int len = nums.length;
        if(len == 1) return true;
        for(int i=0;i<len;i++){
            if(i > far) {
                return false;
            }
            if(far >= len-1)
                return true;
            far = Math.max(far, i+nums[i]);
        }
        return false;
        
    }
}
// @lc code=end

