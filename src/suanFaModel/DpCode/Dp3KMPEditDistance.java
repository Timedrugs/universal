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

    /**
     * 从后往前移动2个字符串
     * if s1[i] == s2[j]:
     *     啥都别做（skip）
     *     i, j 同时向前移动
     * else:
     *     三选一：
     *         插入（insert）
     *         删除（delete）
     *         替换（replace）
     */

    public int minDistance(String word1, String word2) {

        int s1Len = word1.length(), s2Len = word2.length();

        if (s1Len == 0){
            return s2Len;
        }

        if (s2Len == 0){
            return s1Len;
        }
        int[][] dp = new  int[s1Len][s2Len];
        for (int i = 0; i < s1Len; i++){
            dp[s1Len][0] = word1.charAt(i);
        }

        for (int i = 0; i < s1Len; i++){
            dp[0][s2Len] = word2.charAt(i);
        }

        for (int i = 0; i < s1Len; i++){
            for (int j = 0; j < s2Len; j++){

            }
        }
    }
}
