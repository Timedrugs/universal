/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/19 1:15 下午
 */
public class 各数相加258 {

    public static void main(String[] args) {
        各数相加258 cl = new 各数相加258();
        cl.addDigits(38);
    }

    public int addDigits(int num) {

        while(num >= 10){
            num = (num - 1) % 9 + 1;
        }
        return num;
    }

}
