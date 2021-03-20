/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/16 1:31 下午
 */
public class 滑动窗口最大值 {

    public static void main(String[] args) {
        滑动窗口最大值 cl = new 滑动窗口最大值();
//        System.out.println(Arrays.toString(cl.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
        System.out.println(Arrays.toString(cl.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(cl.maxSlidingWindow1(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
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

                //刚好k个元素，移除第一个，窗口右移
                if (nums[right - k + 1] == windows.get(0)) {
                    windows.remove(0);
                }
                valid--;
            }

            right++;
        }

        return res;
    }

    private void listPut(List<Integer> list, int value){
        while (list.size() > 0 && value > list.get(list.size() - 1)){
            list.remove(list.size() - 1);
        }
        list.add(value);
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int  len = nums.length;
        if (len == 0){
            return new int[]{};
        }

        List<Integer> windows = new ArrayList<>();
        int[] res = new int[len - k + 1];
        int right = 0;
        int valid = 0;
        int index = 0;

        while(right < len ){
            int cur = nums[right];

            listPut1(windows, cur);
            valid++;

            if(valid == k){
                res[index] = windows.get(0);
                index++;
                if(windows.get(0) == (nums[right - k + 1])){
                    windows.remove(0);
                }
                valid--;
            }
            right++;
        }
        return res;
    }

    private void listPut1(List<Integer> list, int value){

        while(list.size() > 0 && value > list.get(list.size() - 1)){
            list.remove(list.size() - 1);
        }
        list.add(value);
    }
}
