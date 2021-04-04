package TrainingCamp.HomeWork.FourthWeek;

/**
 * @author xiaokuo
 * @since 2021/4/5 12:01 上午
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class 比特位计数 {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 1; i <= num; i++){
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;
    }
}
