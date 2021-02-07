/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.DpCode;

/**
 * 不同的定义产生不同的解法 https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484469&idx=1&sn=e8d321c8ad62483874a997e9dd72da8f&chksm=9bd7fa3daca0732b316aa0afa58e70357e1cb7ab1fe0855d06bc4a852abb1b434c01c7dd19d6&scene=178&cur_album_id=1318881141113536512#rd
 *
 * @author xiaokuo
 * @since 2021/2/7 11:16 上午
 */
public class Dp4Key {

    public static void main(String[] args) {
        Dp4Key cl = new Dp4Key();
        System.out.println(cl.solve(7));
    }

    /**
     * 651
     * 今天聊一道 4 键键盘问题，这个问题挺有意思，而且可以明显感受到：对 dp 数组的不同定义需要完全不同的逻辑，从而产生完全不同的解法。
     * 类似dp2
     * 时间复杂度 O(n^2)
     */
    private int solve(int n) {

        if (n <= 5) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {

            //按下 a, 操作数-1  ， a的数量+1
            dp[i] = dp[i - 1] + 1;

            for (int j = 2; j < i; j++) {

                //j-2 按下c-a,c-c
                //全选&复制 dp[j-2] 连续粘贴i-j次
                //屏幕出现dp[j - 2] * (i - j + 1) 个A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }

        return dp[n];
    }
}
