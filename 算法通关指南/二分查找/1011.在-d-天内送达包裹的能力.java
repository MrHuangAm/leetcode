package 算法通关指南.二分查找;
/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;        // 二分搜索下限
        int right = 0;       // 二分搜索上限
        for (int weight : weights) {
            left = Math.max(left, weight);  // 下限：最大单件重量 , 否则会载不动
            right += weight;                // 上限：总重量， 一次性载完
        }
        while(left < right){
            int mid = left + (right-left)/2;
            if(canTrans(weights, mid, days)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;

    }
    public boolean canTrans(int[] weights,int load,int days){
        int sum = 0;
        int ans = 1;
        for (int i = 0; i < weights.length; i++) {
            if(weights[i]+sum <= load){
                sum += weights[i];
            }else{
                ans++;
                sum = weights[i];
            }
        }
        return ans <= days;
    }
}
// @lc code=end

