/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // 当生成的括号组合长度达到 2 * max 时，添加到结果列表
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // 如果左括号数量小于 max，添加左括号
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            // 回溯，撤销上一步添加的左括号
            current.deleteCharAt(current.length() - 1);
        }

        // 如果右括号数量小于左括号数量，添加右括号
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            // 回溯，撤销上一步添加的右括号
            current.deleteCharAt(current.length() - 1);
        }
    }
}
// @lc code=end

