package suanFaModel.StackAndQueueCode;

import java.util.Stack;

/**
 * @author xiaokuo
 * @since 2021/1/18 12:25 上午
 */
public class StackCode {

    public static void main(String[] args) {

        StackCode cl = new StackCode();
        System.out.println(cl.isValid("{[]}}"));
    }

    /**
     * 20
     * 给定一个只包括 ‘(’，’)’，’{’，’}’，’[’，’]’ 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * // 输入: "()[]{}"
     * //输出: true
     * //
     * //
     * // 示例 3:
     * //
     * // 输入: "(]"
     * //输出: false
     */
    public boolean isValid(String s) {

        if(s.length() <= 1){
            return  false;
        }

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++){
            char cur = s.charAt(i);
            if (cur == '('){
                stack.push(')');
            }else if(cur == '['){
                stack.push(']');
            }else if(cur == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop() != cur){
                return  false;
            }
        }

        return  stack.isEmpty();
    }

    /**
     * 155
     * php
     */


}
