/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 将 wordDict 转换为 Set，提高查找效率
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        // dp[i] 表示 s 的前 i 个字符能否由 wordDict 中的单词拼接而成
        boolean[] dp = new boolean[n + 1];
        // 空字符串可以被拼接
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 若前 j 个字符能被拼接，且从 j 到 i 的子字符串在 wordDict 中
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
// @lc code=end

