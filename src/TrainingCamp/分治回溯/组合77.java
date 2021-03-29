/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.分治回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/29 8:43 下午
 * https://leetcode-cn.com/problems/combinations/
 * 77
 */
public class 组合77 {
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> path = new ArrayList();
        List<List<Integer>> res = new ArrayList<>();
        divide(n, k, res, path);
        return res;
    }

    private void divide(int n, int k, List<List<Integer>> res, List<Integer> path){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= n; i++){
            
            //过滤
            if (path.contains(i)){
                continue;
            }
            //选择
            path.add(i);
            //下一层
            divide(n, k, res, path);
            //清楚
            path.remove(path.size() - 1);
        }
    }
}
