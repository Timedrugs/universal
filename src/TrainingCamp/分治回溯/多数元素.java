/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.分治回溯;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/29 8:34 下午
 * https://leetcode-cn.com/problems/majority-element/description/
 * 169
 */
public class 多数元素 {


    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len < 1){
            return -1;
        }
        int count = 0;
        int k = -1;
        for (int num : nums){

            if(count == 0){
                count++;
                k = num;
                continue;
            }
            if (k == num){
                count++;
            }else{
                count--;
            }
        }
        //可以确认下是否超过了半数

        return k;
    }
}
