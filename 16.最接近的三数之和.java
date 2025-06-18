/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请你从 nums 中选出三个整数，使它们的和与 target 最接近
 * 返回这三个数的和。
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        // 初始化时要设置为第一个值，否则会错误
        int ans = nums[0] + nums[1] + nums[len-1];
        int dist = Math.abs(ans-target);
        // 记得排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < dist){
                    ans = sum;
                    dist = Math.abs(target - sum);
                }
                if(sum < target) left++;
                else if (sum > target) right--;
                else return ans;
            }
        }
        return ans;
    }
}
// @lc code=end

