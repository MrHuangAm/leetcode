package 算法通关指南.二分查找;

/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] preSum = new int[len+1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int minLen = Integer.MAX_VALUE;
        if(preSum[nums.length] < target) return 0;
        for(int i = 0; i<=len;i++){
            int left = i;
            int right = len;
            while(left <= right){
                int mid = left + (right-left) / 2;
                if(preSum[mid]-preSum[i] < target) {
                    left = mid + 1;
                }else{
                    minLen = Math.min(minLen, mid - i);
                    right = mid - 1;
                }
            }
        }
        return minLen;
    }
}
// @lc code=end

