/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        LinkedList<TreeNode> lt = new LinkedList<>();
        lt.addLast(root);

        while(!lt.isEmpty()){
            int levelSize = lt.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode first = lt.poll();
                // 最后一个结点也要添加左右子树，别忘了
                if (i == levelSize - 1) {
                    ans.add(first.val);
                }
                if(first.left != null) lt.offer(first.left);
                if(first.right != null) lt.offer(first.right);
            }
            // ans.add(lt.poll().val);
        }
        return ans;
    }
}
// @lc code=end

