package TrainingCamp.HomeWork.SecondWeek;

/**
 * @author xiaokuo
 * @since 2021/3/21
 */
public class 搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1 && target != nums[0]){
            return -1;
        }

        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            // 右边界左移  第一种情况
            if (nums[left] <= nums[mid] && target <= nums[mid] && nums[left] <= target)  {
                right = mid;
            }else if (nums[left] > nums[mid] && (target >= nums[left] || target <= nums[mid])){
                // 右边界左移  第二种情况
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left == right && nums[left]==target? left : -1;
    }
}
