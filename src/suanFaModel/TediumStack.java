/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈
 *https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487704&idx=1&sn=eb9ac24c644aa0950638c9b20384e982&chksm=9bd7eed0aca067c6b4424c40b7f234c815f83edfbb5efc9f51581335f110e9577114a528f3ec&scene=178&cur_album_id=1318892385270808576#rd
 * @author xiaokuo
 * @since 2021/2/4 5:05 下午
 */
public class TediumStack {

    /**
     * 模板
     * 把数组的元素想象成并列站立的人，元素大小想象成人的身高。
     * 这些人面对你站成一列，如何求元素「2」的 Next Greater Number 呢？
     * 很简单，如果能够看到元素「2」，那么他后面可见的第一个人就是「2」的 Next Greater Number，
     * 因为比「2」小的元素身高不够，都被「2」挡住了，第一个露出来的就是答案。
     *
     * 分析它的时间复杂度，要从整体来看：总共有n个元素，每个元素都被push入栈了一次，
     * 而最多会被pop一次，没有任何冗余操作。所以总的计算规模是和元素规模n成正比的，也就是O(n)的复杂度。
     */
    private int[] nextGreaterElement(int[] nums){
        // 存放答案的数组
        int len = nums.length;
        int[]  ret = new   int[len];
        Stack<Integer> stack = new Stack<>();

        //倒着往栈里放
        for(int i = len - 1; i >= 0; i--){

            //判断个子高矮
            while (!stack.empty() && stack.peek() <= nums[i]){
                // 矮个起开，反正也被挡着了。。。
                stack.pop();
            }
            // nums[i] 身后的 next great number
            ret[i] = stack.empty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        TediumStack cl = new TediumStack();
        System.out.println(Arrays.toString(cl.dailyTemperatures(new int[]{73,74,75,71,69,76})));
        System.out.println(Arrays.toString(cl.nextGreaterElements(new int[]{1,2,1})));
    }


    /**
     * 1118 一个月多少天
     * 给你一个数组T，这个数组存放的是近几天的天气气温，你返回一个等长的数组，
     * 计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0。
     * 比如说给你输入T = [73,74,75,71,69,76]，你返回[1,1,3,2,1,0]。
     * 解释：第一天 73 华氏度，第二天 74 华氏度，比 73 大，所以对于第一天，只要等一天就能等到一个更暖和的气温，后面的同理。
     */
    private  int[] dailyTemperatures(int[] t){
        int len = t.length;
        if (len <= 0){
            return new int[]{};
        }
        int[] ret = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i = len - 1; i >= 0;i--){

            while (!stack.empty() && t[i] >= t[stack.peek()]){
                stack.pop();
            }

            ret[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return  ret;
    }

    /**
     * 如何处理循环数组
     *
     */

    /**
     *  503 下一个更大元素 II
     *  给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
     *  数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
     * 一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     *
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * //数字 2 找不到下一个更大的数；
     * //第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if(len <= 0){
            return new int[]{};
        }

        int[] ret = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * len - 1; i >= 0; i--){

            int m = i % len;
            while (!stack.empty() && stack.peek() <= nums[m]){
                stack.pop();
            }

            ret[m] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[m]);
        }
        return  ret;
    }


}
