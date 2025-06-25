/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int targetPos = nums.length - k;
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int pivot = partition(nums, left, right);
            if (pivot == targetPos) {
                return nums[pivot];
            } else if (pivot < targetPos) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

    // 添加随机化优化
    private int partition(int[] nums, int left, int right) {
        // 随机选择基准值
        int randomIndex = left + (int)(Math.random() * (right - left + 1));
        swap(nums, left, randomIndex);
        
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

