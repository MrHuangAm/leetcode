package 算法通关指南.树.二叉搜索树;


/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第 K 小的元素
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
class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode node, int k) {
        if (node == null || count >= k) return;
        
        traverse(node.left, k);  // 遍历左子树
        
        count++;  // 访问当前节点
        if (count == k) {
            result = node.val;
            return;
        }
        
        traverse(node.right, k); // 遍历右子树
    }
}
// @lc code=end

