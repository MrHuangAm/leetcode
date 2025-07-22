package 算法通关指南.二分查找;
/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // int mid = (left + right) / 2;
            // 尝试从长度为 k + 1 的连续子区间删除一个元素
            // 从而定位左区间端点的边界值
            if (x - arr[mid] > arr[mid + k] - x) {
                // 下一轮搜索区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left..mid]
                right = mid;
            }
        }
        // 1 2 3 4 5 6 8 7 x=5 k = 3
        //     m l r

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
// @lc code=end

