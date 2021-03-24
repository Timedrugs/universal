package TrainingCamp.分治;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaokuo
 * @since 2021/3/24 10:50 下午
 */
public class 括号生成22 {

    public static void main(String[] args) {
        括号生成22 cl = new 括号生成22();
        cl.generateParenthesis(3);
    }

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        if (n == 0){
            return res;
        }

        divide(n, n, "");
        return res;
    }

    private void divide(int left, int right, String str){

        if(right == 0 && left == 0){
            res.add(str);
            return;
        }

        if(left > 0){
            divide(left - 1, right, str + "(");
        }

        if(right > left){
            divide(left, right - 1, str + ")");
        }
    }
}
