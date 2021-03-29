/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.分治回溯;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/29 7:57 下午
 * https://leetcode-cn.com/problems/next-permutation/
 * 31
 */
public class 下一个排列 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }

        if(i >= 0){
            int j = nums.length - 1;
            while (nums[i] >= nums[j] && j > 0){
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start){

        int left = start, right = nums.length - 1;

        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
