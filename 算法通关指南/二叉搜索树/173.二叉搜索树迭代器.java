package 算法通关指南.二叉搜索树;
/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
 */

// @lc code=start

import java.util.Stack;

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
class BSTIterator {
    public TreeNode dummy;
    public Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    public TreeNode pushLeft(TreeNode root){
        st.push(root);
        if(root.left == null) return root;
        return pushLeft(root.left);
    }
    public int next() {
        TreeNode peek = st.pop();
        if(peek.right != null){
            pushLeft(peek.right);
        }
        return peek.val;
    }
    
    public boolean hasNext() {
        return st.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

