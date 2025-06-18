/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentValue = getValue(s.charAt(i));
            if (i < s.length() - 1) {
                int nextValue = getValue(s.charAt(i + 1));
                if (currentValue < nextValue) {
                    // 特殊组合，用下一个数值减去当前数值
                    result += nextValue - currentValue;
                    i++; // 跳过下一个字符
                } else {
                    result += currentValue;
                }
            } else {
                result += currentValue;
            }
        }
        return result;
    }

    // 获取单个罗马字符对应的数值
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
// @lc code=end

