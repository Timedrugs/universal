package TrainingCamp.HomeWork.FourthWeek;

/**
 * @author xiaokuo
 * @since 2021/4/4 10:21 下午
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        爬楼梯 cl = new 爬楼梯();
        System.out.println(cl.climbStairs(4));
    }

    public int climbStairs(int n) {

        if(n == 0){
            return 0;
        }

        int[] dp = new int[n + 1];
        //切记这里一定要写==1
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return  dp[n];
    }
}
