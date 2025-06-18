/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    private int rows;
    private int cols;
    private char[][] board;
    private String word;
    private boolean[][] visited;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;
        this.word = word;
        this.visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int index) {
        // 若当前字符不匹配或者该单元格已访问过，返回 false
        if (board[x][y] != word.charAt(index)) {
            return false;
        } 
        // 若已匹配到单词的最后一个字符，返回 true
        if (index == word.length() - 1) {
            return true;
        }
        // 标记当前单元格为已访问
        visited[x][y] = true;
        // 向四个方向进行搜索
        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isValid(newX, newY) && !visited[newX][newY]) {
                if (dfs(newX, newY, index + 1)) {
                    return true;
                }
            }
        }
        // 回溯，撤销当前单元格的访问标记
        visited[x][y] = false;
        return false;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
// @lc code=end

