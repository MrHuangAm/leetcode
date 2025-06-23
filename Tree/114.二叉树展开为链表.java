/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
/*
 * 递归法的核心思路是利用二叉树的后序遍历。
 * 先递归处理左右子树，将左右子树分别展开为链表，
 * 然后将左子树链表接到根节点的右子节点位置，
 * 再将原来的右子树链表接到左子树链表的末尾。
 */

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 递归展开左子树
        flatten(root.left);
        // 递归展开右子树
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        // 将左子树移到右子树位置
        root.left = null;
        root.right = left;

        // 找到新右子树的最右节点
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        // 将原右子树接到新右子树的末尾
        p.right = right;
    }
}

// @lc code=end

