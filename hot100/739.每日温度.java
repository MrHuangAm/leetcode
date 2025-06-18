/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // 初始化结果数组
        int[] answer = new int[n];
        // 单调递减栈，存储元素的索引
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 当栈不为空，且栈顶元素对应的温度小于当前温度
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                // 计算下一个更高温度出现的天数
                answer[index] = i - index;
            }
            // 将当前元素的索引压入栈中
            stack.push(i);
        }
        return answer;
    }
}
// @lc code=end

