/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.分治;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/24 8:27 下午
 */
public class 括号生成22 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 输入：n = 3
     * //输出：["((()))","(()())","(())()","()(())","()()()"]
     */
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return  res;
        }

        help("", n, n, res);
        return res;
    }
    //当前字符  左等级  右等级  数量
    public void help(String str,int lLevel, int rLevel, List<String> res){

        if (lLevel == 0 && rLevel == 0){
            res.add(str);
            return;
        }

        if (lLevel > 0){
            help(str + "(", lLevel--, rLevel, res);

        }

        if (rLevel > lLevel){
            help(str + ")", lLevel, rLevel--, res);
        }
    }


}
