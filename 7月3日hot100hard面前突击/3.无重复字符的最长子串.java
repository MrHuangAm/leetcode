/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int[] isExt = new int[200];
        Arrays.fill(isExt, -1);
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i);
            if(isExt[idx] != -1){
                // 不为-1的情况，新的位置不一定比当前更靠后
                left = Math.max(isExt[idx]+1,left);
            }
            isExt[idx] = i;
            maxLen = Math.max(i-left+1 , maxLen);
            System.out.println(i-left + 1);
        }
        return maxLen;
    }
}
// @lc code=end

