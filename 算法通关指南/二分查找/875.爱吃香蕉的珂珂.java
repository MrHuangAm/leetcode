package 算法通关指南.二分查找;
/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 至少为1h
        int right = 1,left=1;
        for (int i : piles) {
            right = Math.max(i, right);
        }
        while(left < right){
            int k = left + (right-left)/2;
            //防止除零
            if(k == 0) break;
            int count = 0;
            for (int i : piles) {
                count += (i%k == 0? i/k : i/k+1);
            }
            if(count > h) left = k +1;
            else if(count <= h) right = k;
        }
        return left;
    }
}
// @lc code=end

