/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 记录行、列、九宫格的数字使用情况
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] boxes = new boolean[9][9];

    //将九宫格中的空格单独提取出来，然后进行回溯
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        // 初始化数据结构
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    //将九宫格中的空格单独提取出来，然后进行回溯
                    spaces.add(new int[]{i, j});
                } else {
                    int num = c - '0' - 1;
                    int boxIdx = (i / 3) * 3 + j / 3;
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIdx][num] = true;
                }
            }
        }
        backtrack(board, 0);
    }

    private boolean backtrack(char[][] board, int index) {
        if (index == spaces.size()) {
            return true;
        }
        
        int[] pos = spaces.get(index);
        int i = pos[0], j = pos[1];
        int boxIdx = (i / 3) * 3 + j / 3;

        for (int num = 0; num < 9; num++) {
            // 剪枝：检查数字是否可用
            if (!rows[i][num] && !cols[j][num] && !boxes[boxIdx][num]) {
                // 填入数字
                board[i][j] = (char) (num + '0' + 1);
                rows[i][num] = cols[j][num] = boxes[boxIdx][num] = true;
                
                // 递归尝试下一个空格
                if (backtrack(board, index + 1)) {
                    return true;
                }
                
                // 回溯恢复状态
                board[i][j] = '.';
                rows[i][num] = cols[j][num] = boxes[boxIdx][num] = false;
            }
        }
        return false;
    }
}
// @lc code=end

