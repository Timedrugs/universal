package suanFaModel;

/**
 * @author xiaokuo
 * @since 2021/2/28 8:55 下午
 */
public class GreedyCode {

    public static void main(String[] args) {
        GreedyCode cl  = new GreedyCode();
        System.out.println(cl.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    /**
     * 122
     * 股票问题
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int len = prices.length;

        if (len == 0){
            return 0;
        }

        int pre = prices[0];
        int cur = 0;
        int count = 0;
        for (int i = 1; i < len ; i++){
            cur = prices[i];
            if (cur < pre){
                pre = cur;
                continue;
            }

            count += (cur - pre);
            pre = cur;
        }

        return  count;
    }
}
