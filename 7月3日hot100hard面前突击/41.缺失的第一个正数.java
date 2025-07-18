/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while(nums[i]<=nums.length && nums[i]>0
            && nums[i] != i+1 
            && nums[i] != nums[nums[i]-1]) 
                swap(nums,i,nums[i]-1);
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
    public void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

