/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.DpCode;

import static java.lang.Math.min;

/**
 * TODO Description
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484731&idx=1&sn=f1db6dee2c8e70c42240aead9fd224e6&chksm=9bd7fb33aca07225bee0b23a911c30295e0b90f393af75eca377caa4598ffb203549e1768336&scene=21#wechat_redirect
 * 递归算法的时间复杂度怎么计算？子问题个数乘以解决一个子问题需要的时间。
 *
 * @author xiaokuo
 * @since 2021/2/5 12:29 下午
 */
public class Dp1Code {

    public static void main(String[] args) {
        Dp1Code cl = new Dp1Code();
//        System.out.println(cl.fib(1));
        System.out.println(cl.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(cl.coinChange(new int[]{2}, 3));
    }


    //斐波那契数列 dp题解
    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int[] ret = new int[n + 1];
        ret[0] = 0;
        ret[1] = 1;
        ret[2] = 1;
        for (int i = 3; i <= n; i++) {
            ret[i] = ret[i - 1] + ret[i - 2];
        }

        return ret[n];
    }

    /**
     * 凑零钱问题
     *
     * amount = 11
     * coins = [1,2,5]
     * 题解： 11 分化到 1，2，5上
     * 即： 11-1， 11-2， 11-5  子问题
     * 然后继续下分，不过需要子问题+1， 即可理解为11= 10+1
     *
     */
    /**
     * 伪框架
     */
//    private int coinChangeModel(int[] coins, int amount) {
////        我们要求目标金额是 amount
//        return dp(amount, coins);
//    }
//    // 定义：要凑出金额 n，至少要 dp(n) 个硬币
//    private int dp(int n, int[] coins) {
//        int res = Integer.MAX_VALUE;
////        做选择，需要硬币最少的那个结果就是答案
//        for (int coin : coins) {
//            res = min(res, 1 + dp(n - coin, coins));
//        }
//        return res;
//    }

    // coins 中是可选硬币面值，amount 是目标金额
    private int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0) {
            return -1;
        }

        if (amount < -1) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            //初始化数组元素
            dp[i] = -1;
            int min = amount + 1;
            for (int coin: coins) {

                // 当前口袋钱远大于amount  凑出上一个amount高于当前最大值  上一个无法根据零钱凑出
                if (i < coin || dp[i - coin] > min || dp[i - coin] == -1){
                    continue;
                }
                dp[i] = min = 1 + dp[i - coin];
            }
        }
        return dp[amount];
    }

}
