/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel;

/**
 * 二分
 *
 * @author xiaokuo
 * @since 2021/2/7 10:25 上午
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch cl = new BinarySearch();
    }

    /**
     * 模板
     * 有序数组
     */
    private int binarySearchModel(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        //要点1： start + 1 < end
        while (start + 1 < end) {
            //重点二
            int mid = start + (end - start) / 2;

            //要点三： = <  > 分开讨论， mid 不+1 也不-1
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }

        //要点四 循环结束，单独处理start end
        if (nums[start] == target){
            return start;
        }

        if (nums[end] == target){
            return end;
        }

        return -1;
    }


}
