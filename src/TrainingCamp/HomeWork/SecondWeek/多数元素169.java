package TrainingCamp.HomeWork.SecondWeek;

/**
 * @author xiaokuo
 * @since 2021/3/21
 */
public class 多数元素169 {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int len = nums.length;

        if (len < 1){
            return 0;
        }

        int count = 0;
        int zs = 0;
        for (int i = 0; i < len; i++){
            if (count == 0){
                count++;
                zs = nums[i];
                continue;
            }

            if (nums[i] == zs){
                count++;
            }else{
                count--;
            }
        }

        //防有人抄底
        int k = 0;
        for (int j: nums) {

            if (j == zs){
                k++;
            }

            if (k > len / 2){
                return  zs;
            }
        }

        return  0;
    }
}
