package TrainingCamp.HomeWork.ThirdlyWeek;

/**
 * @author xiaokuo
 * @since 2021/3/28
 * 32
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == ')') {

                //上一个为'(' 时 长度 dp[i - 2] + 2
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] + 2 : 2);
                } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
