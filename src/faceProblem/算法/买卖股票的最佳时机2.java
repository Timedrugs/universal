package faceProblem.算法;

/**
 * @author xiaokuo
 * @since 2021/4/7 10:56 下午
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
 */
public class 买卖股票的最佳时机2 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if(len < 1){
            return 0;
        }

        int res = 0;
        int pre = 0;
        for(int i = 0; i < len; i++){
            int cur = prices[i];
            if(i == 0){
                pre = cur;
                continue;
            }

            if(cur > pre){
                res += cur - pre;
            }
            pre = cur;
        }
        return res;
    }
}
