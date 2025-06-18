/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        // 数组长度小于 3，无法构成三元组，直接返回空列表
        if (n < 3) {
            return result;
        }
        // 对数组进行排序
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            // 已经排好序了，如果当前数大于 0，后续三数之和肯定大于 0，结束循环
            if (nums[i] > 0) {
                break;
            }
            // 跳过重复元素
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 找到满足条件的三元组
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 移动指针
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 和小于 0，左指针右移
                    left++;
                } else {
                    // 和大于 0，右指针左移
                    right--;
                }
            }
        }
        return result;
    }
}
// @lc code=end

