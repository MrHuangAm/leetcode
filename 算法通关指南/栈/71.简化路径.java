package 算法通关指南.栈;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        // 添加虚拟终止符确保处理最后一段
        String normalizedPath = path + "/";
        
        for (int i = 0; i < normalizedPath.length(); i++) {
            char c = normalizedPath.charAt(i);
            
            if (c == '/') {
                String segment = sb.toString();
                
                // 处理特殊目录
                if (segment.equals("..")) {
                    if (!st.isEmpty()) st.pop();
                } 
                // 忽略当前目录和空段
                else if (!segment.equals(".") && !segment.isEmpty()) {
                    st.push(segment);
                }
                
                sb.setLength(0); // 清空缓存
            } else {
                sb.append(c); // 累积目录名字符
            }
        }
        
        // 构建最终路径
        if (st.isEmpty()) return "/";
        
        StringBuilder res = new StringBuilder();
        for (String dir : st) {
            res.append('/').append(dir);
        }
        
        return res.toString();
    }
}
// @lc code=end

