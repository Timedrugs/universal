package suanFaModel.StackAndQueueCode;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author xiaokuo
 * @since 2021/1/18 12:26 上午
 */
public class QueueCode {

    public static void main(String[] args) {

        QueueCode cl = new QueueCode();
        System.out.println(Arrays.toString(cl.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(cl.maxSlidingWindowV1(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }

    /**
     * 239
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
     *
     * //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * //输出：[3,3,5,5,6,7]
     * //解释：
     * //滑动窗口的位置                最大值
     * //---------------               -----
     * //[1  3  -1] -3  5  3  6  7       3
     * // 1 [3  -1  -3] 5  3  6  7       3
     * // 1  3 [-1  -3  5] 3  6  7       5
     * // 1  3  -1 [-3  5  3] 6  7       5
     * // 1  3  -1  -3 [5  3  6] 7       6
     * // 1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        int len = nums.length;
        if (len == 0){
            return nums;
        }

        if (k >= len){
            return  new int[]{Arrays.stream(nums).max().getAsInt()}  ;
        }

        int[] res = new  int[len - k + 1];

        int[] windows = new int[k];
        int right = 0, left = 0, index = 0, resIndex = 0;
        int valid = 0;
        while (right < len){

            int cur = nums[right];
            if (valid < k){
                windows[index] = cur;
                valid = valid < k ? valid + 1 : valid;
                index = index >= k - 1 ? k - 1 : index + 1;
            }
            right++;
            if (valid == k){
                res[left] = Arrays.stream(windows).max().getAsInt();
                windows = formatArr(windows);
                valid--;
                left++;
            }

        }
        return  res;
    }
    public int[] formatArr(int[]  arr){

        if (arr.length <= 1){
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++){
            arr[i] = arr[i+1];
        }

        return arr;
    }
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int [] nums;
    //{{{???
    public int[] maxSlidingWindowV1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx]) max_idx = i;
        }
        int [] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i  = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }
    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k){
            deq.removeFirst();
        }

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
            deq.removeLast();
        }
    }
    //}}}???

    /**
     * 844
     */



}
