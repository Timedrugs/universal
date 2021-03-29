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
 * @since 2021/3/22 1:51 下午
 */
public class 全排列 {

    public static void main(String[] args) {
        全排列 cl = new 全排列();
        cl.permute(new int[]{1,2,3});
    }
    /**
     * 46 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * https://leetcode-cn.com/problems/permutations/
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485007&idx=1&sn=ceb42ba2f341af34953d158358c61f7c&chksm=9bd7f847aca071517fe0889d2679ead78b40caf6978ebc1d3d8355d6693acc7ec3aca60823f0&scene=21#wechat_redirect
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length == 0){
            return res;
        }
        //记录路径
        List<Integer> path = new ArrayList();
        dfs(nums, res, path);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path){
        //结束条件
        if(nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        int len = nums.length;
        for(int i = 0; i < len; i++){

            //排除不合法的
            if(path.contains(nums[i])){
                continue;
            }

            //做选择
            path.add(nums[i]);

            //进入下一层
            dfs(nums, res, path);

            //取消选择
            path.remove(path.size() - 1);
        }
    }

}
