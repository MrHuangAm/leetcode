package 算法通关指南.区间问题;
/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> 
            a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] e : envelopes) {
            int h = e[1];
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < h) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = h;
            if (left == len) len++;
        }
        return len;
    }
}
// @lc code=end

