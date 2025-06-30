package 算法通关指南.树.二叉搜索树;

/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证p的值小于q的值，简化后续判断
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        
        while (root != null) {
            if (root.val > q.val) {        // 当前节点值大于两个目标值，往左找
                root = root.left;
            } else if (root.val < p.val) { // 当前节点值小于两个目标值，往右找
                root = root.right;
            } else {                       // 当前节点值在两个目标值之间，即为LCA
                return root;
            }
        }
        return null;
    }
}
// @lc code=end

