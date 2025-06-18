/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
class TreeNode{
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
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        // 返回偷与不偷根节点两种状态下的最大金额
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // 递归处理左子节点
        int[] left = dfs(node.left);
        // 递归处理右子节点
        int[] right = dfs(node.right);

        int[] dp = new int[2];
        // 不偷当前节点，左右子节点可偷可不偷，取最大金额之和
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点，左右子节点不能偷
        dp[1] = node.val + left[0] + right[0];

        return dp;
    }
}
// @lc code=end

