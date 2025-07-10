package 算法通关指南.二分查找;

/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int len = m*n;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int i = mid / m;
            int j = mid % m;
            if(matrix[i][j] < target){
                left = mid + 1;
            }else if (matrix[i][j] > target){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

