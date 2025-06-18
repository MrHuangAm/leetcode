/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        // 如果行数为 1 或者行数大于等于字符串长度，直接返回原字符串
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // 用于存储每一行的字符串
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // 当前行索引
        int curRow = 0;
        // 方向，1 表示向下，-1 表示向上
        int direction = -1;

        for (char c : s.toCharArray()) {
            // 将字符添加到当前行
            rows[curRow].append(c);
            // 到达第一行或最后一行时，改变方向
            if (curRow == 0 || curRow == numRows - 1) {
                direction = -direction;
            }
            // 移动到下一行
            curRow += direction;
        }

        // 合并所有行的字符串
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
// @lc code=end

