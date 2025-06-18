/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            int k = i;
            while(j<needle.length() && k<haystack.length() && haystack.charAt(k) == needle.charAt(j)){
                k++;j++;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }
}
// @lc code=end

