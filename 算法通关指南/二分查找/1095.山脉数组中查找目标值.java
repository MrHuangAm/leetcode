package 算法通关指南.二分查找;
/*
 * @lc app=leetcode.cn id=1095 lang=java
 *
 * [1095] 山脉数组中查找目标值
 */

// @lc code=start
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int left = 0;
        int right = mountainArr.length()-1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        int peek = left;
        left = 0;
        right = peek;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mountainArr.get(mid) < target){
                left = mid + 1;
            }else if (mountainArr.get(mid) > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        left = peek;
        right = mountainArr.length()-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mountainArr.get(mid) > target){
                left = mid + 1;
            }else if (mountainArr.get(mid) < target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
// @lc code=end

