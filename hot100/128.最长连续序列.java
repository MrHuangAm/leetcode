/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxLen = 0;
        // 将数组元素添加到 HashSet 中
        for(int num : nums) set.add(num);
        // 直接遍历 HashSet 中的元素
        for(int num : set){
            if(!set.contains(num - 1)){
                int tmp = 0;
                while(set.contains(num + tmp)){
                    tmp++;
                }
                maxLen = Math.max(maxLen, tmp);
            }
        }
        return maxLen;
    }
}
// @lc code=end

