/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 确保 nums1 是较短的数组，这样可以减少二分查找的范围
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;

        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            if (i < m && nums2[j-1] > nums1[i]) {
                // i 太小，需要增大
                imin = i + 1;
            } else if (i > 0 && nums1[i-1] > nums2[j]) {
                // i 太大，需要减小
                imax = i - 1;
            } else {
                // i 是完美的分割点
                int maxOfLeft;
                if (i == 0) {
                    maxOfLeft = nums2[j-1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i-1];
                } else {
                    maxOfLeft = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                int minOfRight;
                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        // 不会执行到这里，只是为了满足编译要求
        throw new IllegalArgumentException();
    }
}
// @lc code=end

