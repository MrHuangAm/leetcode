/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        // 记录跳跃次数
        int steps = 0;
        // 当前跳跃能到达的最远位置
        int end = 0;
        // 下一步跳跃能到达的最远位置
        int maxPosition = 0;
        // 遍历到倒数第二个位置即可，因为最后一步不需要跳跃
        for (int i = 0; i < n - 1; i++) {
            // 更新下一步跳跃能到达的最远位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达当前跳跃能到达的最远位置
            if (i == end) {
                // 进行一次跳跃
                steps++;
                // 更新当前跳跃能到达的最远位置
                end = maxPosition;
            }
        }
        return steps;
    }
}
// @lc code=end

