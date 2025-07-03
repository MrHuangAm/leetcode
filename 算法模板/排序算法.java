package 算法模板;
/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        // bubbleSort(nums);
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int left,int right){
        if(left >= right) return;
        int pivot = nums[left];
        int i = left;
        int j = right;
        while(i < j){
            while(i < j && nums[j] >= pivot) j--;
            while(i < j && nums[i] <= pivot) i++;
            if(i < j) swap(nums, i, j);
        }
        swap(nums, i, left);
        quickSort(nums, left, i-1);
        quickSort(nums, i + 1, right);
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // public void mergeSort(int[] nums){}

    // public void heapSort(int[] nums){}

    // public void bubbleSort(int[] nums){
    //     for (int i = 1; i < nums.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //                 if(nums[j]>nums[i]){
    //                     int tmp = nums[i];
    //                     nums[i] = nums[j];
    //                     nums[j] = tmp;
    //                 }
    //         }
    //     }
    // }

    // public void shellSort(int[] nums){}

    // public void countSort(int[] nums){}
}
// @lc code=end

