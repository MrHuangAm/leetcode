/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        // 记录每个字母最后一次出现的位置
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 更新当前片段的结束位置
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                // 当前片段结束，记录长度
                result.add(end - start + 1);
                // 更新下一个片段的起始位置
                start = i + 1;
            }
        }
        return result;
    }
}
// @lc code=end

