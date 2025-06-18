/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。

 * 本题可以使用位运算的方法来解决。
 * 因为除了目标数字外，其他数字都出现三次，
 * 所以可以统计数组中每个数字的每一位上 1 的出现次数，然后对 3 取余，
 * 最终得到的结果就是只出现一次的数字在该位上的值。
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        // 遍历 32 位整数的每一位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            // 统计数组中所有数字在第 i 位上 1 的出现次数
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            // 对 3 取余，得到只出现一次的数字在第 i 位上的值
            if (count % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
// @lc code=end

