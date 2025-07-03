/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int[] preSum = new int[nums.length+1];
        int left = 0;
        int right = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        while(right<preSum.length && preSum[right] < target){
            right ++;
        }
        int minLen = Integer.MAX_VALUE;
        while(right<preSum.length){
            int tpRight = right;
            while(left < right){
                int mid = left + (tpRight - left)/2;
                if(preSum[tpRight] - preSum[mid] < target){
                    tpRight = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            minLen = Math.min(minLen, right-left);
            right ++;
        }
        return minLen;

        
    }
}
// @lc code=end

