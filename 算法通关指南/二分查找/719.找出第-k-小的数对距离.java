/*
 * @lc app=leetcode.cn id=719 lang=java
 *
 * [719] 找出第 K 小的数对距离
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1]-nums[0];
        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = effectPair(nums, mid);
            if(count >= k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public int effectPair(int[] nums,int dist){
        int left = 0;
        int count = 0;
        for (int right = 1; right < nums.length; right++) {
            while(left < right && nums[right]-nums[left] > dist){
                left++;
            }
            count += right-left;
        }
        return count;
    }
}
// @lc code=end

