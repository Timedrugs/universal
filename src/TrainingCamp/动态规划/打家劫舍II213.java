/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.动态规划;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/26 2:09 下午
 */
public class 打家劫舍II213 {

    public static void main(String[] args) {
        打家劫舍II213 cl = new 打家劫舍II213();
//        System.out.println(cl.rob(new int[]{2,3,2}));
        System.out.println(cl.rob(new int[]{1,2,3}));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0], nums[1]);
        }

        return 1;
    }

}
