/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 * 本题可利用异或运算（^）的特性来解决，异或运算有以下重要性质：
 * 任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0 = a。
 * 任何数和其自身做异或运算，结果是 0，即 a ^ a = 0。
 * 异或运算满足交换律和结合律，即 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b。
 * 基于这些性质，对数组中所有元素进行异或运算，出现两次的元素会相互抵消（结果为 0），
 * 最终剩下的就是只出现一次的元素。
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        // 遍历数组，对所有元素进行异或运算
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
// @lc code=end

