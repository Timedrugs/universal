package TrainingCamp.HomeWork;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/10 1:58 下午
 */
public class FirstWeek {

    /**
     * 11 成最多谁容器
     * https://leetcode-cn.com/problems/container-with-most-water/
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int len = height.length;

        if (len == 0){
            return 0;
        }

        int ret = 0;

        return ret;
    }

    /**
     * 283 移动0
     * https://leetcode-cn.com/problems/move-zeroes/
     */
    public void moveZeroes(int[] nums) {

        int len = nums.length;

        int j = 0;
        for(int i = 1; i < len; i++){
            if (nums[i]==0){
                continue;
            }

            if (nums[j] == 0){
                nums[j] = nums[i];
                j++;
                continue;
            }
        }
    }
}
