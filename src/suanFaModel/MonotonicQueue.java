/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 239
 * 单调队列 「单调队列」这个数据结构可以解决滑动窗口问题。
 * <p>
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488087&idx=1&sn=673aa4e8deb942b951948650928c336e&chksm=9bd7ec5faca06549ba6176540fef04f93c1c9f55b303106688b894a2029e00b8cce1a9ba57a4&scene=178&cur_album_id=1318892385270808576#rd
 *
 * 单独看push操作的复杂度确实不是O(1)，但是算法整体的复杂度依然是O(N)线性时间。
 * 要这样想，nums中的每个元素最多被push_back和pop_back一次，没有任何多余操作，所以整体的复杂度还是O(N)。
 *
 * @author xiaokuo
 * @since 2021/2/5 11:16 上午
 */
public class MonotonicQueue {

    LinkedList<Integer> q = new LinkedList<>();

    /**
     * 模板
     */
    // 在队尾添加元素 n
    void push(int n) {
        // 将小于 n 的元素全部删除
        while (!q.isEmpty() && q.getLast() < n) {
            q.pollLast();
        }
        // 然后将 n 加入尾部
        q.addLast(n);
    }

    // 返回当前队列中的最大值
    int max() {
        return q.getFirst();
    }

    // 队头元素如果是 n，删除它
    void pop(int n) {
        if (n == q.getFirst()) {
            q.pollFirst();
        }
    }

    int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先把窗口的前 k - 1 填满
                window.push(nums[i]);
            } else {
                // 窗口开始向前滑动
                // 移入新元素
                window.push(nums[i]);
                // 将当前窗口中的最大元素记入结果
                res.add(window.max());
                // 移出最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        // 将 List 类型转化成 int[] 数组作为返回值
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }


}
/**
 * 239
 */
class Solution {

    public static void main(String[] args) {
        Solution cl = new Solution();
        System.out.println(Arrays.toString(cl.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }

    LinkedList<Integer> list = new LinkedList<>();

    private void push(int n) {

        while (!list.isEmpty() && n > list.getLast()) {
            //移除
            list.pollLast();
        }
        list.addLast(n);
    }

    private void pop(int n) {
        if (n == list.getFirst()) {
            list.pollFirst();
        }
    }

    private int max() {
        return list.getFirst();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < 1) {
            return nums;
        }

        if (k >= len) {
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }

        if (k == 1) {
            return nums;
        }

        Solution windows = new Solution();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {

            if (i < k - 1) {
                windows.push(nums[i]);
            } else {
                windows.push(nums[i]);
                res.add(windows.max());
                windows.pop(nums[i - k + 1]);
            }
        }

        //list to array
        int size = res.size();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
