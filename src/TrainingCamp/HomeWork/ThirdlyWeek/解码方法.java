package TrainingCamp.HomeWork.ThirdlyWeek;

/**
 * @author xiaokuo
 * @since 2021/3/28 6:35 下午
 * https://leetcode-cn.com/problems/decode-ways/
 * 91
 *
 * https://leetcode-cn.com/problems/decode-ways/solution/mmplao-niang-zhong-yu-xie-chu-lai-liao-by-vegetabl/
 */
public class 解码方法 {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 1; i < n; i++){

            if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <'7'){
                //如果是20、10
                if(s.charAt(i) == '0'){
                    dp[i + 1] = dp[i - 1];
                } else{
                    //如果是11-19、21-26

                    dp[i + 1] = dp[i] + dp[i - 1];
                }
            }else if(s.charAt(i) == '0'){
                //如果是0、30、40、50
                return 0;
            }else{
                //i-1和i无法构成一个字母
                dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }
}
