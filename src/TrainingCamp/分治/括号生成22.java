package TrainingCamp.分治;

import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * @author xiaokuo
 * @since 2021/3/24 10:50 下午
 */
public class 括号生成22 {

    public static void main(String[] args) {
        括号生成22 cl = new 括号生成22();
        cl.generateParenthesis(3);
    }
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
    public void help(String str,int left, int right, List<String> res){

        if (left == 0 && right == 0){
            res.add(str);
            return;
        }

        if(left > 0){
            help(str + "(", left - 1, right, res);
        }

        if(right > left){
            help(str + ")", left, right - 1, res);
        }
    }
}
