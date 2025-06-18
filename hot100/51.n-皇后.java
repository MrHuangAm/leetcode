/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// 导入 List 和 ArrayList 类
import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    private List<List<String>> result = new ArrayList<>();
    private boolean[] cols;
    private boolean[] mainDiagonals;
    private boolean[] antiDiagonals;

    public List<List<String>> solveNQueens(int n) {
        // 初始化棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        // 初始化标记数组
        cols = new boolean[n];
        mainDiagonals = new boolean[2 * n - 1];
        antiDiagonals = new boolean[2 * n - 1];
        backtrack(board, 0);
        return result;
    }

    private void backtrack(char[][] board, int row) {
        int n = board.length;
        if (row == n) {
            result.add(constructSolution(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n)) {
                board[row][col] = 'Q';
                // 标记列和对角线
                cols[col] = true;
                mainDiagonals[row - col + n - 1] = true;
                antiDiagonals[row + col] = true;
                backtrack(board, row + 1);
                // 回溯，撤销标记
                board[row][col] = '.';
                cols[col] = false;
                mainDiagonals[row - col + n - 1] = false;
                antiDiagonals[row + col] = false;
            }
        }
    }

    private boolean isValid(int row, int col, int n) {
        // 检查列和对角线是否有皇后冲突
        return !cols[col] && !mainDiagonals[row - col + n - 1] && !antiDiagonals[row + col];
    }

    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }
}
// @lc code=end

