/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) return s;
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1; // 能走到这里，至少长度为1
        int start = 0;
        for(int i=0;i<len;i++) dp[i][i] = true;
        for(int curLen = 2;curLen<=len;curLen++){ //枚举长度而不是边界，这样才能确保获取上一步的值
            for(int i = 0;i+curLen<=len;i++){
                int j = i + curLen -1;
                if(s.charAt(i) == s.charAt(j)){
                    if(curLen == 2) dp[i][j] = true; // 长度为2时，如果相等需要特判，因为dp[i+1][j-1]此时为false
                    else dp[i][j] = dp[i+1][j-1];
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j] && curLen > maxLen){
                    maxLen = curLen;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
// @lc code=end

