/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.DpCode;

/**
 * 最长递增子序列
 *
 * @author xiaokuo
 * @since 2021/2/5 4:47 下午
 *
 */
public class Dp2MaxLongSubsequenceCode {

    public static void main(String[] args) {
        Dp2MaxLongSubsequenceCode cl = new Dp2MaxLongSubsequenceCode();
        System.out.println(cl.findNumberOfLIS(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(cl.findNumberOfLIS(new int[]{111,1}));
        System.out.println(cl.findNumberOfLIS(new int[]{7,7,7,7,7}));
    }

    /**
     * 300  最长子序列
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     *
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484498&idx=1&sn=df58ef249c457dd50ea632f7c2e6e761&chksm=9bd7fa5aaca0734c29bcf7979146359f63f521e3060c2acbf57a4992c887aeebe2a9e4bd8a89&scene=178&cur_album_id=1318881141113536512#rd
     * 复杂度 O(n^2)
     */
    public int findNumberOfLIS(int[] nums) {

        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int res = Integer.MIN_VALUE;
        int[] dp = new int[len];

        //统计 i 之前的各个元素的最长子序列长度
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                int cur = nums[j];
                int pre = nums[i];

                if (cur >= pre){
                    continue;
                }
                dp[i] = java.lang.Math.max(dp[j] + 1, dp[i]);
            }

        }

       for (int j: dp){
           res = res > j ? res : j;
       }

       return res;
    }



}
