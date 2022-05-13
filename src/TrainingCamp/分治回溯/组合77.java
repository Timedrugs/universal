/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.分治回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/29 8:43 下午
 * https://leetcode-cn.com/problems/combinations/
 * 77
 */
public class 组合77 {

    public static void main(String[] args) {
        组合77 cl = new 组合77();
        System.out.println(cl.combine(4, 2));
    }
    public List<List<Integer>> combine(int n, int k) {

//        List<Integer> path = new ArrayList();
        Set<Integer> path = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, res, path);
        return res;
    }

    private void dfs(int start, int n, int k, List<List<Integer>> res, Set<Integer> path){

        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++){

            //过滤
            if (path.contains(i)){
                continue;
            }
            //选择
            path.add(i);
            //下一层  下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(i + 1, n, k, res, path);
            //清楚
            path.remove(i);
        }
    }
}
