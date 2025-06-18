/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start



/**
 * Definition for a binary tree node.

 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，或者当前节点就是 p 或 q，返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归遍历左子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归遍历右子树
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左右子树都不为空，说明 p 和 q 分别在左右子树中，当前节点就是最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 如果左子树不为空，右子树为空，返回左子树的结果
        if (left != null) {
            return left;
        }
        // 否则返回右子树的结果
        return right;
    }
}
// @lc code=end

