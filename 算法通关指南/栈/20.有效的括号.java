package 算法通关指南.栈;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            if (top == -1 || !isPair(s.charAt(i),stack[top])) {
                stack[++top] = s.charAt(i); 
            }else if(top > -1 && isPair(s.charAt(i),stack[top])){
                top--;
            }
        }
        return top == -1;
    }
    public boolean isPair(char b,char a){
        if (a == '(' && b == ')') return true;
        if (a == '{' && b == '}') return true;
        if (a == '[' && b == ']') return true;
        return false;
    }
}
// @lc code=end

