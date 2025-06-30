/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {
    SegmentTreeNode treeRoot;
    public NumArray(int[] nums) {
        treeRoot = buildTree(nums, 0, nums.length-1);
    }
    
    public void update(int index, int val) {
        updateSegmentTree(treeRoot,index,val);
    }
    
    public int sumRange(int left, int right) {
        return queryRange(treeRoot, left, right);
    }
    public void updateSegmentTree(SegmentTreeNode root, int index, int val){
        if(root.start == root.end){
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if(index <= mid) updateSegmentTree(root.leftNode,index,val);
        else updateSegmentTree(root.rightNode,index,val);
        root.sum = root.leftNode.sum + root.rightNode.sum;
    }
    public SegmentTreeNode buildTree (int[] nums,int start, int end){
        if(start > end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        if(start == end) root.sum = nums[start];
        else{
            int mid = start + (end - start) / 2;
            root.leftNode = buildTree(nums, start, mid);
            root.rightNode = buildTree(nums, mid+1, end);
            root.sum = root.leftNode.sum + root.rightNode.sum;
        }
        return root;
    }
    public int queryRange(SegmentTreeNode root,int start,int end){
        if(root.end < start || root.start > end) return 0;
        else if(root.start >= start && root.end <= end) return root.sum;
        else return queryRange(root.leftNode, start, end) + queryRange(root.rightNode, start, end);
    }
    class SegmentTreeNode{
        int sum;
        int start,end;
        SegmentTreeNode leftNode,rightNode;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

