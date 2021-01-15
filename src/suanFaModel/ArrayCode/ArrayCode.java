/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.ArrayCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/1/15 4:13 下午
 */
public class ArrayCode {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,5};
        int[] nums1 = new int[]{1,3,5,6};
        ArrayCode cl = new  ArrayCode();

        System.out.println(13/10);
        System.out.println(13%10);

//        System.out.println(cl.searchInsert(nums, 2));
//        System.out.println(cl.searchInsertV1(new int[]{1,3,4}, 3));
//        System.out.println(cl.removeElement(new int[]{2}, 2));
        System.out.println(Arrays.toString(cl.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(cl.plusOne(new int[]{9,9,9})));
    }

    /**
     * 35
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * / 输入: [1,3,5,6], 2
     * //输出: 1
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return 1;
        }

        int len = nums.length;
        for(int i = 0; i < len; i++){
            if (target <= nums[i]){
                return i;
            }
        }

        return len;
    }
    public int searchInsertV1(int[] nums, int target) {

        int len = nums.length;
        if (len == 0){
            return 1;
        }
        int left = 0, right = len - 1;
        while (left <= right){

            int middle = left + ((right - left)/2);
//
            if (target < nums[middle]){
                right = middle - 1;
            }else if(target > nums[middle]){
                left = middle + 1;
            }else{
                while (middle-- >= 0){

                    if (middle <= 0 && target <= nums[0]){
                        return 0;
                    }else if (middle <= 0 && target > nums[0]){
                        return 1;
                    }

                    if (target > nums[middle]){
                        return middle+1;
                    }
                }
            }

           if (left > right){
               return left;
           }
        }

        return len;
    }

    /**
     * 27
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * //
     * // 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * //
     * // 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {

        if (nums.length == 0){
            return 0;
        }

        int len = nums.length;

//        if (len == 1 && nums[0] == val){
//            return 0;
//        }
//        if (len == 1 && nums[0] != val){
//            return 1;
//        }


        int right = nums.length - 1;
        int left  = 0 ;

        while(left <= right){

            while (left <= right && left < len && nums[left] != val){
                left++;
            }

            while (left <= right && right >= 0 && nums[right] == val){
                right--;
            }

            if (left <= right ){
                nums[left] = nums[right];
                left++;
                right--;
            }
        }

        return left;
//        int i = 0;
//        int j = nums.length-1;
//        while (i <= j){
//            while (i <= j && i < nums.length && nums[i] != val) {
//                i++;
//            }
//            while (i <= j && j >= 0 && nums[j] == val) {
//                j--;
//            }
//            if ( i <= j) {
//                nums[i] = nums[j];
//                i++;
//                j--;
//            }
//        }
//        return i;

    }

    /**
     * 1
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * //
     * // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * / 给定 nums = [2, 7, 11, 15], target = 9
     * //
     * //因为 nums[0] + nums[1] = 2 + 7 = 9
     * //所以返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        if (len < 2){
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len;i++){

            int a = target - nums[i];
            if (map.containsKey(a)){
                return new int[]{map.get(a), i};
            }

            map.put(nums[i], i);
        }
        return  new int[]{};
    }

    /**
     * 66
     * //给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * //
     * // 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * //
     * // 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * /输入：digits = [1,2,3]
     * //输出：[1,2,4]
     * //解释：输入数组表示数字 123。
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len -1; i >= 0;i--){

            digits[i]++;

            digits[i] %= 10;
            //如果最后一位对10求余不等于0，则for循环值进行了一次就返回了，只把最后的数字进行了加一
            //不然的话，对10求余等于0，之后还自增加一表示进位了，再对进位加一的那个书判断是否等于10

            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new  int[len + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 11
     *
     */
//    public int maxArea(int[] height) {
//
//    }

    /**
     * 59
     * //给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * //
     * // 示例:
     * //
     * // 输入: 3
     * //输出:
     * //[
     * // [ 1, 2, 3 ],
     * // [ 8, 9, 4 ],
     * // [ 7, 6, 5 ]
     * //]
     */
    public int[][] generateMatrix(int n) {

    }

}
