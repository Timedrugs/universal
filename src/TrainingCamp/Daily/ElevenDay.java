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
 * @since 2021/3/18 1:25 下午
 */
public class ElevenDay {

    public static void main(String[] args) {
        ElevenDay cl = new ElevenDay();
        System.out.println(cl.fizzBuzz(15));
    }
    /**
     * 412
     */
    public List<String> fizzBuzz(int n) {
//        1. 如果 n 是3的倍数，输出“Fizz”；
//
// 2. 如果 n 是5的倍数，输出“Buzz”；
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
        List<String> res = Arrays.asList(new String[n]);
        if (n == 0){
            return  res;
        }
        if (n == 1){
            res.set(0, String.valueOf(n));
            return res;
        }
        int left = 0;
        int right = n - 1;
        while (left <= right){
            if((left + 1) % 15 == 0){
                res.set(left, "FizzBuzz");
            }else if((left + 1) % 5 == 0){
                res.set(left, "Buzz");
            }else if((left + 1) % 3 == 0 ){
                res.set(left, "Fizz");
            }else{
                res.set(left, String.valueOf(left + 1));
            }
            if (left == right){
                break;
            }

            if((right + 1) % 15 == 0){
                res.set(right, "FizzBuzz");
            }else if((right + 1)  % 5 == 0){
                res.set(right, "Buzz");
            }else if((right + 1) % 3 == 0 ){
                res.set(right, "Fizz");
            } else{
                res.set(right, String.valueOf(right + 1));
            }
            left++;
            right--;
        }
        return res;
    }

}
