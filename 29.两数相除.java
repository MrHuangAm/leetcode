/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 * 给你两个整数，被除数 dividend 和除数 divisor。
 * 将两数相除，要求 不使用 乘法、除法和取余运算。
 * 
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。
 * 例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的 商。
 * 
 * 设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2147483648,  2147483647] 。
 * 本题中，如果商 严格大于 2147483647 ，则返回 2147483647 ；
 * 如果商 严格小于 -2147483648 ，则返回 -2147483648 。
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        // 处理特殊情况：被除数为 Integer.MIN_VALUE 且除数为 -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 判断结果的正负
        boolean isNegative = (dividend > 0) ^ (divisor > 0);

        // 将被除数和除数都转换为负数，方便处理
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int result = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int multiple = 1;
            // 通过位运算快速找到除数的最大倍数
            while (dividend - temp <= temp) {
                temp <<= 1;
                multiple <<= 1;
            }
            // 从被除数中减去该倍数对应的部分
            dividend -= temp;
            result += multiple;
        }

        // 根据正负性返回结果
        return isNegative ? -result : result;
    }
}
// @lc code=end

