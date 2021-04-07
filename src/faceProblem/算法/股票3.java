package faceProblem.算法;

/**
 * @author xiaokuo
 * @since 2021/4/7 11:22 下午
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class 股票3 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 1){
            return 0;
        }
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;

        for(int price: prices){
            fstBuy = Math.max(fstBuy, -price);
            fstSell = Math.max(fstSell, fstBuy + price);

            secBuy = Math.max(secBuy, fstSell - price);
            secSell = Math.max(secSell, secBuy + price);
        }
        return secSell;
    }
}
