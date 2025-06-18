/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128]; // 扩展数组大小以处理所有 ASCII 字符
        int left = 0;
        int right = 0;
        int len = s.length();
        int maxLen = 0;
        for(;right<len;right++){
            if(map[s.charAt(right)] != 0){
                // 将 left 指针移动到重复字符的下一个位置
                left = Math.max(left, map[s.charAt(right)]);
            }
            // 更新字符的最新位置
            map[s.charAt(right)] = right + 1;
            // 更新最大长度
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
// @lc code=end

