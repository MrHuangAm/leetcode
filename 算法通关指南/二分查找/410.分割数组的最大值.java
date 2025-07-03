package 算法通关指南.二分查找;

/*
 * @lc app=leetcode.cn id=410 lang=java
 *
 * [410] 分割数组的最大值
 * 
问：如何保证二分结果一定对应着一个划分成 k 段的方案？

答：把二分结果代入 check 函数，可以得到一个划分成 ≤k 段的方案。在此基础上，可以得到划分成 k 段的方案。
比如划分成 k−1 段，那么把其中的一个长度至少为 2 的段分成两段，这两段的元素和都比原来的一段小，也满足题目要求，
这样就得到了一个划分成 k 段的方案。换句话说，题目其实相当于：把数组划分成至多 k 段。

问：设二分算出来的答案为 ans，如何保证至少有一个子数组的元素和恰好等于 ans？

答：用反证法证明。假设所有子数组的元素和都小于 ans，这意味着 check(ans−1)=true，
但是二分结束后必定有 check(ans−1)=false，矛盾，所以至少有一个子数组的元素和恰好等于 ans。

 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int k) {
        // 确定二分边界
        long left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num); // 左边界为数组最大值
            right += num;               // 右边界为数组总和
        }

        while(left < right){
            long maxVal = left + (right - left) /2;
            // 在最大值为maxVal的条件下，能否分割为k个数组
            if (canSplit(nums, k, maxVal)) {
                //如果可以，则缩小范围
                right = maxVal;
            }else{
                left = maxVal+1;
            }
        }
        return (int) right;
    }
    private boolean canSplit(int[] nums, int k, long maxVal){
        int count = 1;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > maxVal) {
                sum = 0;
                count++;
            }
            if(count > k || nums[i]>maxVal) return false;
            sum+=nums[i];
        }
        return true;
    }
}
// @lc code=end

