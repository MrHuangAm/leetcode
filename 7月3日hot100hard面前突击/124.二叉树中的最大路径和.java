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
    private int maxLen = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return maxLen;
    }
    public int oneSideMax(TreeNode root){
        if(root == null) return 0;

        int leftMaxLen = Math.max(0,oneSideMax(root.left));
        int rightMaxLen = Math.max(0, oneSideMax(root.right));
        maxLen = Math.max(maxLen, root.val + leftMaxLen + rightMaxLen);
        return root.val + Math.max(leftMaxLen, rightMaxLen);
    }

}
// @lc code=end

