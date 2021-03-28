package TrainingCamp.动态规划;

/**
 * @author xiaokuo
 * @since 2021/3/28 3:51 下午
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 53
 */
public class 最大子序和 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0){
            return 0;
        }

        int[] dp = new int[len + 1];
        //这里可以直接定义 dp = nums;
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < len; i++){

            //比较当前值  和当前+上一个值
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if(dp[i] > max){
                max = dp[i];
            }

        }
        return  max;
    }
}
