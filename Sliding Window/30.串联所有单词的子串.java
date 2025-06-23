/*
 * @lc app=leetcode.cn id=30 lang=java
 *
 * [30] 串联所有单词的子串
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        // 单个单词的长度
        int wordLength = words[0].length();
        // 单词的总数
        int totalWords = words.length;
        // 所有单词串联后的总长度
        int totalLength = wordLength * totalWords;
        // 统计 words 数组中每个单词的出现频率
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 遍历不同的起始位置
        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i;
            Map<String, Integer> currentCount = new HashMap<>();
            int formed = 0;

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    if (currentCount.get(word).equals(wordCount.get(word))) {
                        formed++;
                    }
                }

                while (right - left == totalLength) {
                    if (formed == wordCount.size()) {
                        result.add(left);
                    }
                    String leftWord = s.substring(left, left + wordLength);
                    left += wordLength;

                    if (wordCount.containsKey(leftWord)) {
                        if (currentCount.get(leftWord).equals(wordCount.get(leftWord))) {
                            formed--;
                        }
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

