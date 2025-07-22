package 算法通关指南.栈;
/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(sb.length() == 0 || s.charAt(i) != sb.charAt(sb.length()-1)){
                sb.append(s.charAt(i));
            }
            else if(sb.length() != 0 && s.charAt(i) == sb.charAt(sb.length()-1)){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

