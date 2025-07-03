package 算法模板;


/**
 * 树状数组模板（用于计算前缀和）
 * 特性：
 * 1. 支持单点更新 O(logn)
 * 2. 支持前缀查询 O(logn)
 * 3. 下标从1开始（重要！）
 */
class FenwickTree {
    private int[] tree;
    private int[] nums;
    public FenwickTree(int[] nums){
        tree = new int[nums.length+1];
        this.nums = nums;
        for (int i = 1; i <= nums.length; i++) {
            tree[i] += nums[i-1];
            int nxt = i + lowbit(i);
            if(nxt <= nums.length){
                tree[nxt] += tree[i];
            }
        }
    }
    public int preSum(int i){
        int sum = 0;
        while(i > 0){
            sum += tree[i];
            i -= lowbit(i);
        }
        return sum;
    }
    public void update(int idx,int val){
        int delta = val - nums[idx];
        nums[idx] += delta;
        int i = idx + 1;
        while(i < tree.length){
            tree[i] += delta;
            i = i + lowbit(i);
        }
    }
    public int rangeSum(int start,int end){
        return preSum(end+1) - preSum(start);
    }
    public int lowbit(int x){
        return x & (-x);
    }
}