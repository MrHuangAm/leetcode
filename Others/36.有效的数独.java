/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];    // 记录每行数字出现情况
        boolean[][] cols = new boolean[9][9];    // 记录每列数字出现情况
        boolean[][] boxes = new boolean[9][9];   // 记录每个九宫格出现情况

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                
                int num = c - '0' - 1; // 将字符转换为0-8的数字索引
                int boxIdx = (i / 3) * 3 + j / 3; // 计算九宫格索引
                
                // 检查当前数字是否已在行、列或九宫格中出现过
                if (rows[i][num] || cols[j][num] || boxes[boxIdx][num]) {
                    return false;
                }
                
                // 更新三个记录数组
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[boxIdx][num] = true;
            }
        }
        return true;
    }
}
// @lc code=end

