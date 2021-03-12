package TrainingCamp.HomeWork;

/**
 * @author xiaokuo
 * @since 2021/3/11 9:30 下午
 */
public class FirstWeek {

    public static void main(String[] args) {
        FirstWeek cl = new FirstWeek();

        cl.rotate(new int[]{1, 2}, 3);
    }

    /**
     * 189 旋转数组
     * https://leetcode-cn.com/problems/rotate-array/
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        if (len < 2){
            return;
        }
        //k 大于 len 超出长度
        k %= len;
        //整体倒叙
        reverse(nums, 0, len - 1);
        //前k个倒叙
        reverse(nums, 0, k - 1);
        //后len - k倒叙
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        if (nums.length == 0){
            return;
        }

        while (start < end){

            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }

    }

}
