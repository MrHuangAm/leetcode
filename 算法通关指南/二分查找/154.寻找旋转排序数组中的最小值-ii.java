package 算法通关指南.二分查找;
/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = left + ( right - left ) / 2;
            
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] == nums[right]){
                right--;
            }
            else {
                right = mid;
            }
        }
        System.out.println(left);
        // right = len - 1;
        // while(left <= right){
            
        // }
        return nums[left];
    }
}
// @lc code=end

