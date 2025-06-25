/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 */

// @lc code=start
class Solution {
    private int[][] direction = new int[][]{{-1,1},{1,-1}};
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int i=0,j=0;
        int dir = 0;
        for (int k = 0; k < m*n; k++) {
            res[k] = mat[i][j];
            int nextI = i + direction[dir][0];
            int nextJ = j + direction[dir][1];
            // 边界处理
            if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n) {
                if (dir == 0) { // 当前是右上方向
                    if (nextJ >= n) {   // 右边界
                        i = i + 1;
                    } else {            // 上边界
                        j = j + 1;
                    }
                } else {        // 当前是左下方向
                    if (nextI >= m) {   // 下边界
                        j = j + 1;
                    } else {            // 左边界
                        i = i + 1;
                    }
                }
                dir = (dir + 1) % 2; // 切换方向
            } else {
                i = nextI;
                j = nextJ;
            }
        }
        return res;
    }
}
// @lc code=end

