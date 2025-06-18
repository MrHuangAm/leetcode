/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        // 按区间的起始位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 用于存储合并后的区间
        List<int[]> merged = new ArrayList<>();
        // 初始化第一个区间
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 获取结果集中最后一个区间
            int[] lastInterval = merged.get(merged.size() - 1);
            int[] currentInterval = intervals[i];
            // 判断是否重叠
            if (currentInterval[0] <= lastInterval[1]) {
                // 重叠则合并区间，更新结果集中最后一个区间的结束位置
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                // 不重叠则直接添加当前区间到结果集
                merged.add(currentInterval);
            }
        }
        // 将 List 转换为二维数组
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end

