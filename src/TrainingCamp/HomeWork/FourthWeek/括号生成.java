package TrainingCamp.HomeWork.FourthWeek;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaokuo
 * @since 2021/4/4 11:18 下午
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class 括号生成 {

    public static void main(String[] args) {
        括号生成 cl = new 括号生成();
        System.out.println(cl.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if(n == 0){
            return  res;
        }

        dfs(res, "",  n, n);
        return res;
    }

    private void dfs(List<String> res, String str, int left, int right) {

        if(left == 0 && right == 0){
            res.add(str);
            return;
        }
        if(left > 0){
            dfs(res, str + "(", left - 1, right);
        }

        if(right > left){
            dfs(res, str + ")", left, right - 1);
        }
    }
}
