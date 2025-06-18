/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    private List<List<String>> result = new ArrayList<>();
    private List<String> path = new ArrayList<>();
    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        int n = s.length();
        // 动态规划预处理，判断所有子串是否为回文串
        dp = new boolean[n][n];
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }
        backtrack(s, 0);
        return result;
    }

    private void backtrack(String s, int startIndex) {
        // 当 startIndex 等于字符串长度时，说明已经完成一种分割方案
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 如果从 startIndex 到 i 的子串是回文串
            if (dp[startIndex][i]) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
                // 递归处理剩余字符串
                backtrack(s, i + 1);
                // 回溯
                path.remove(path.size() - 1);
            }
        }
    }
}
// @lc code=end

