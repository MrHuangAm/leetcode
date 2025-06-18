package Others;
/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。

 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // 特殊情况处理：负数和以 0 结尾的非零数字不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        while (x > reversedNumber) {
            // 反转数字，将 x 的最后一位添加到 reversedNumber 中
            reversedNumber = reversedNumber * 10 + x % 10;
            // 去掉 x 的最后一位
            x /= 10;
        }

        // 当数字长度为奇数时，reversedNumber 会比 x 多一位，通过除以 10 去掉中间位
        return x == reversedNumber || x == reversedNumber / 10;
    }
}
// @lc code=end

