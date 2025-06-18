/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// @lc code=start

class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 通过排序 + 去重，确保最终结果不重复
        Arrays.sort(candidates);
        dfs(new ArrayList<>(),0, 0, candidates, target);
        return res;
    }
    public void dfs(List<Integer> ans,int cur,int sum,int[] candidates,int target){
        if(sum == target){
            res.add(new ArrayList<>(ans));
        }else if(sum > target){
            return;
        }

        for(int i=cur;i<candidates.length;i++){
            //跳过重复数字
            if(i > cur && candidates[i] == candidates[i - 1]){
                continue;
            }
            sum += candidates[i];
            ans.add(candidates[i]);
            dfs(ans,i+1, sum, candidates, target);
            sum -= candidates[i];
            ans.remove(ans.size()-1);
        }
        
    }
}
// @lc code=end

