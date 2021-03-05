/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 *https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=21#wechat_redirect
 * @author xiaokuo
 * @since 2021/3/5 11:39 上午
 */
public class BackArithmeticCode {

    public static void main(String[] args) {
        BackArithmeticCode cl = new BackArithmeticCode();
        System.out.println(cl.permute(new int[]{1,2,3}));
    }



    /**
     * 模板
     */
    List<List<Integer>> res = new LinkedList<>();
//    List<List<Integer>> res = new ArrayList<>();
    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
//        List<Integer> track = new ArrayList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
//            track.remove(track.size() - 1 );
        }
    }

    List<List<Integer>>  ret = new  LinkedList<>();
    private  List<List<Integer>> fAction(int[]  arr){
        if (arr.length == 0){
            return res;
        }
        LinkedList<Integer> track = new LinkedList<>();
        help(arr, track);
        return  ret;
    }

    void help(int[] arr, LinkedList<Integer> track){
        
    }
}

