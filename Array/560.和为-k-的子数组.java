/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 前缀和需要包括为0的点
        int preSum[] = new int[len+1];
        int res = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i-1];
        }
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if(preSum[j]-preSum[i] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
// @lc code=end
