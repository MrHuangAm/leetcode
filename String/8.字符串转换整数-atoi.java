/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        // 去除字符串前后的空白字符
        s = s.trim();
        int len = s.length();
        if (len == 0) return 0;

        // 符号标记，1 表示正数，-1 表示负数
        int sign = 1;
        int index = 0;

        // 处理正负号
        if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        int result = 0;
        while (index < len) {
            char c = s.charAt(index);
            // 判断是否为数字字符
            if (!Character.isDigit(c)) {
                break;
            }
            int digit = c - '0';

            // 溢出判断
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // 累加数字
            result = result * 10 + digit;
            index++;
        }

        return sign * result;
    }
}
// @lc code=end

