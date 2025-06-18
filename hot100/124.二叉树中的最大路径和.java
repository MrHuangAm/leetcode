/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    // 全局最大路径和
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return maxSum;
    }

    // 计算从当前节点出发的单边最大路径和
    private int oneSideMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 递归计算左子树的单边最大路径和，若为负数则舍弃
        int leftMax = Math.max(0, oneSideMax(node.left));
        // 递归计算右子树的单边最大路径和，若为负数则舍弃
        int rightMax = Math.max(0, oneSideMax(node.right));
        // 更新全局最大路径和
        maxSum = Math.max(maxSum, node.val + leftMax + rightMax);
        // 返回从当前节点出发的单边最大路径和
        return node.val + Math.max(leftMax, rightMax);
    }
}
// @lc code=end

