/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.分治回溯;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<List<Integer>> res = cl.permuteUnique(new int[]{3,3,0,3});
        System.out.println(res);
    }

    /**
     * 复杂度：时间复杂度：O(n×n!)，其中 n 为序列的长度。
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums. length == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] use = new boolean[nums. length];
        Arrays.sort(nums);
        divide(nums, res, path, use);
        return res;
    }

    private void divide(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] use){

        if (nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++){
            //排除 不合法的
            //当前数== 上一个且i>0 and check[i-1]==0
            if (use[i] || ( i > 0 && nums[i] == nums[i - 1] && use[i - 1])){
                continue;
            }
            //选择
            path.add(nums[i]);
            use[i] = true;
            //进入下一层
            divide(nums, res, path, use);

            //清除
            path.remove(path.size() - 1);
            use[i] = false;
        }

    }


}
