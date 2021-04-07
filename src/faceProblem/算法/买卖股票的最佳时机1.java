package faceProblem.算法;

/**
 * @author xiaokuo
 * @since 2021/4/7 10:56 下午
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class 买卖股票的最佳时机1 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res = 0;
        int pre = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            if(prices[i] < pre){
                pre = prices[i];

            }else{
                res = Math.max(res, prices[i] - pre);
            }
        }

        return res;
    }
}
