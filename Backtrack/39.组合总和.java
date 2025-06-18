/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(new ArrayList<>(),0, 0, candidates, target);
        return res;
    }
    public void dfs(List<Integer> ans,int cur,int sum,int[] candidates,int target){
        if(sum == target){
            res.add(new ArrayList<>(ans));
        }else if(sum > target){
            return;
        }
        // 修改初始指针避免 序列重复
        for(int i=cur;i<candidates.length;i++){
            sum += candidates[i];
            ans.add(candidates[i]);
            dfs(ans,i, sum, candidates, target);
            sum -= candidates[i];
            ans.remove(ans.size()-1);
        }
        
    }
}
// @lc code=end

