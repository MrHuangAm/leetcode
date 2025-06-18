/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        // 用于记录 t 中字符的频率
        int[] need = new int[128];
        // 用于记录窗口内字符的频率
        int[] window = new int[128];
        // 记录 t 中不同字符的数量
        int needCount = 0;
        // 初始化 need 数组和 needCount
        for (char c : t.toCharArray()) {
            if (need[c] == 0) {
                needCount++;
            }
            need[c]++;
        }

        // 左右指针
        int left = 0, right = 0;
        // 记录窗口内已经匹配的字符数量
        int valid = 0;
        // 记录最小覆盖子串的起始位置和长度
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 移入窗口的字符
            char c = s.charAt(right);
            right++;
            // 更新窗口内字符频率
            if (need[c] > 0) {
                window[c]++;
                if (window[c] == need[c]) {
                    valid++;
                }
            }

            // 判断左侧窗口是否需要收缩
            while (valid == needCount) {
                // 更新最小覆盖子串信息
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 移出窗口的字符
                char d = s.charAt(left);
                left++;
                // 更新窗口内字符频率
                if (need[d] > 0) {
                    if (window[d] == need[d]) {
                        valid--;
                    }
                    window[d]--;
                }
            }
        }

        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
// @lc code=end

