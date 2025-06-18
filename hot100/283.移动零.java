/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        // 右指针遍历数组
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                // 交换非零元素到左边
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                // 左指针右移
                left++;
            }
        }
    }
}
// @lc code=end

