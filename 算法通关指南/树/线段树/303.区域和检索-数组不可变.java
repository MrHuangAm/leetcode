package 算法通关指南.树.线段树;
/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
    private SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public int sumRange(int left, int right) {
        return queryRange(root, left, right);
    }

    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    private int queryRange(SegmentTreeNode node, int left, int right) {
        if (node.end < left || node.start > right) return 0;
        if (left <= node.start && node.end <= right) return node.sum;
        return queryRange(node.left, left, right) + queryRange(node.right, left, right);
    }

    class SegmentTreeNode {
        int start, end;
        int sum;
        SegmentTreeNode left, right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

