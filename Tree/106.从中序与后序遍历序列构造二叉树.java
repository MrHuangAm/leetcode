/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(postEnd < postStart){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i] == rootVal){
                rootIdx= i;
                break;
            }
        }
        int leftLen = rootIdx - inStart;
        root.left = buildTreeHelper(inorder, inStart, rootIdx-1, postorder, postStart, postStart+leftLen-1);
        root.right = buildTreeHelper(inorder, rootIdx+1, inEnd, postorder, postStart+leftLen, postEnd-1);

        return root;
    }
}
// @lc code=end

