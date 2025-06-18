/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 用于存储分组结果的哈希表，键为排序后的字符串，值为字母异位词组
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将字符串转换为字符数组
            char[] charArray = str.toCharArray();
            // 对字符数组进行排序
            Arrays.sort(charArray);
            // 将排序后的字符数组转换为字符串，作为哈希表的键
            String key = new String(charArray);
            // 如果键不存在，创建一个新的列表
            map.computeIfAbsent(key, k -> new ArrayList<>());
            // 将原字符串添加到对应键的值列表中
            map.get(key).add(str);
        }
        // 将哈希表中的值转换为列表返回
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

