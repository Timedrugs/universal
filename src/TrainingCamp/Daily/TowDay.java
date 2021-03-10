/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/9 1:18 下午
 */
public class TowDay {

    /**
     * 66
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(len == 0){
            return digits;
        }

        for (int i= len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;

            //如果取模之后 不为0 直接返回，如果为0 证明进位了 需反复加1
            if (digits[i] != 0){
                return digits;
            }
        }

        //此时超出数组最大长度，第一位填充1
        digits = new int[len+1];
        digits[0] = 1;
        return digits;
    }
}
