/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.分治;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/22 1:51 下午
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class 全排列II {

    public static void main(String[] args) {
        全排列II cl = new 全排列II();
        cl.permuteUnique(new int[]{1,1,2});
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums. length == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        divide(nums, res, path);
        return res;
    }

    private void divide(int[] nums, List<List<Integer>> res, List<Integer> path){

        if (nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++){
            //排除 不合法的

            //选择
            path.add(nums[i]);

            //进入下一层
            divide(nums, res, path);

            //清除

        }

    }


}
