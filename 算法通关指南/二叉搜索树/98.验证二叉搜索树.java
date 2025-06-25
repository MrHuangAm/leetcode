package 算法通关指南.二叉搜索树;
/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        // 使用Long类型避免Integer边界值问题
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long leftBound, long rigthbound){
        if(root == null) return true;
        // （BST要求左<根<右）
        if(! (root.val > leftBound && root.val < rigthbound)){
            return false;
        }
        return isValid(root.left, leftBound, root.val) && isValid(root.right, root.val, rigthbound);
    }
}
// @lc code=end

