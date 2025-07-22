package 算法通关指南.二分查找;
/*
 * @lc app=leetcode.cn id=1482 lang=java
 *
 * [1482] 制作 m 束花所需的最少天数
 */

// @lc code=start
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : bloomDay) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        while(min < max){
            int mid = min + ( max - min) / 2 ;
            if(canMake(bloomDay, mid,m, k)){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        if (canMake(bloomDay, min, m, k)) {
            return min;
        } else {
            return -1;
        }
    }
    public boolean canMake(int[] bloomDay,int min,int m,int k){
        int ans = 0;
        int count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if(bloomDay[i] <= min){
                if(count + 1 < k){
                    count++;
                }else if (count + 1 ==k) {
                    ans++;
                    count = 0;
                }
            }else{
                count = 0;
            }
        }
        return ans >= m;
    }
}
// @lc code=end

