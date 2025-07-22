package 算法通关指南.栈;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedList;

class MinStack {
    private LinkedList<int[]> data;
    public MinStack() {
        data = new LinkedList<>();
        data.addLast(new int[]{0,Integer.MAX_VALUE});
    }
    
    public void push(int val) {
        data.add(new int[]{val,Math.min(getMin(), val)});
    }
    
    public void pop() {
        data.removeLast();
    }
    
    public int top() {
        return data.getLast()[0];
    }
    
    public int getMin() {
        return data.getLast()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

