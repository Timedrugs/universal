/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import suanFaModel.SlidingWindow;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/16 1:31 下午
 */
public class EightDay {

    public static void main(String[] args) {
        EightDay cl = new EightDay();
        System.out.println(Arrays.toString(cl.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
    /**
     *Offer 59 - I. 滑动窗口的最大值
     * 2中写法
     * 1. 单调栈  多一些出站 进站判断
     * 2. 非单调栈
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int  len = nums.length;
        if (len == 0){
            return new int[]{};
        }

        List<Integer> windows = new ArrayList<>();
        int[] res = new int[len - k + 1];
        int right = 0;
        int valid = 0;
        int index = 0;
        while (right < len){
            int rCur = nums[right];

            listPut(windows, rCur);
            valid++;

            if (valid == k){
                res[index] = windows.get(0);
                index++;
                windows.remove(0);
            }

            right++;
        }

        return res;
    }

    private void listPut(List<Integer> list, int value){

        if (list.size() == 0){
            list.add(value);
            return;
        }

        while (value > list.get(list.size() - 1)){
            list.remove(list.size() - 1);
        }
        list.add(value);
    }


}
