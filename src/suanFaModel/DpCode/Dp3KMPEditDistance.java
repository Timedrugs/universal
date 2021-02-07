/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.DpCode;

/**
 * 编辑距离
 *
 * @author xiaokuo
 * @since 2021/2/5 6:19 下午
 */
public class Dp3KMPEditDistance {
    /**
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484731&idx=3&sn=aa642cbf670feee73e20428775dff0b5&chksm=9bd7fb33aca0722568ab71ead8d23e3a9422515800f0587ff7c6ef93ad45b91b9e9920d8728e&scene=178&cur_album_id=1318881141113536512#rd
     */
    public static void main(String[] args) {
        Dp3KMPEditDistance cl = new Dp3KMPEditDistance();
        System.out.println(cl.minDistance("horse" ,"ros"));
    }



    /**
     * 从后往前移动2个字符串 if s1[i] == s2[j]: 啥都别做（skip） i, j 同时向前移动
     * else: 三选一： 插入（insert） 删除（delete） 替换（replace）
     */

    public int minDistance(String word1, String word2) {

        int s1Len = word1.length(), s2Len = word2.length();

        if (s1Len == 0) {
            return s2Len;
        }

        if (s2Len == 0) {
            return s1Len;
        }
        int[][] dp = new int[s1Len + 1][s2Len + 1];
        for (int i = 1; i <= s1Len; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= s2Len; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= s1Len; i++) {
            for (int j = 1; j <= s2Len; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = this.minV(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1,
                        dp[i - 1][j - 1] + 1
                    );
                }
            }
        }
        return dp[s1Len][s2Len];
    }

    private int minV(int a, int b, int c){
        return java.lang.Math.min(a, java.lang.Math.min(b,c));
    }
}
