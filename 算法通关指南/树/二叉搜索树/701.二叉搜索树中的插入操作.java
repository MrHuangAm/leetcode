package 算法通关指南.树.二叉搜索树;

/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        insert(root,val);
        return root;
    }
    public void insert(TreeNode root, int val){
        if(root.left == null && root.val > val) root.left = new TreeNode(val);
        if(root.right == null && root.val < val) root.right = new TreeNode(val);
        if(root.left != null && root.val > val) insert(root.left, val);
        if(root.right !=null && root.val < val) insert(root.right, val);
        return ;
    }
}
// @lc code=end

