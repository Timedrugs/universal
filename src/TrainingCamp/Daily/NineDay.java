/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/17 1:10 下午
 */
public class NineDay {

    public static void main(String[] args) {
        NineDay cl = new NineDay();
        System.out.println(cl.removeOuterParentheses("(())()"));
    }
    /**
     * 1021. 删除最外层的括号
     */
    public String removeOuterParentheses(String S) {

        int len = S.length();

        if (len == 0){
            return "";
        }
        int level = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            char cur = S.charAt(i);
            if (cur == ')'){
                --level;
            }

            if (level >= 1){
                sb.append(cur);
            }
            if (cur == '('){
                ++level;
            }
        }
        return sb.toString();
    }

}
