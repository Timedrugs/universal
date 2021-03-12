package TrainingCamp.HomeWork;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/10 1:58 下午
 */
public class FirstWeek {


    /**
     * 11 盛更多水
     *
     */
    public int maxArea(int[] height) {

        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = len - 1;
        while (left < right){
            int high =  Math.min(height[left], height[right]);
            max = Math.max(max, (right-left)*high);

            if (height[left] > height[right]){
                right--;
            }else{
                left++;
            }
        }
        return  max;
    }

    /**
     * 283 移动0
     * https://leetcode-cn.com/problems/move-zeroes/
     *
     */
    public void moveZeroes(int[] nums) {

        int len = nums.length;

        if (len == 0){
            return;
        }

        int j = 0;
        for (int i = 0; i < len; i++){

            if (nums[i] == 0){
                continue;
            }
            nums[j] = nums[i];
            if (i != j){
                nums[i] = 0;
            }
            j++;
        }
        return;
    }

    /**
     * 70 爬楼梯
     *
     */
    public int climbStairs(int n) {

        if (n <= 2){
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 15 三数之和
     */

}
