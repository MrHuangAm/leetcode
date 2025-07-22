package 算法通关指南.栈;
/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] stack = new int[len];
        int top = -1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            while(top > -1 && temperatures[stack[top]] < temperatures[i]){
                int cur = stack[top--];
                res[cur] = i-cur;
            }
            stack[++top] = i;
        }
        return res;
    }
}
// @lc code=end

