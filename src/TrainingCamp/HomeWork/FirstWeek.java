package TrainingCamp.HomeWork;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/11 9:30 下午
 */
public class FirstWeek {

    public static void main(String[] args) {
        FirstWeek cl = new FirstWeek();

        cl.rotate(new int[]{1, 2}, 3);
        int[] arr = new int[]{1,1,1,2,2,3,4};
        System.out.println(cl.removeDuplicates(arr));

        int[] arr1 = new int[]{0};
        cl.merge(arr1, 0, new int[]{1}, 1);
        System.out.println(arr1.toString());

        int[] arr2 = new int[]{0,1,0,3,12};
        cl.moveZeroes(arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(cl.isAnagram("anagram","nagaram"));
    }

    /**
     * 189 旋转数组
     * https://leetcode-cn.com/problems/rotate-array/
     * O(n)
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        if (len == 0){
            return;
        }

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

    /**
     * 26 删除数组重复项
     * 时间复杂度 O(n)
     *
     */
    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        int left = 0;
        int right = 1;
        while(right < len){

            if (nums[left] == nums[right]){
                right++;
                continue;
            }

            //判断作用：防止连续不重复数字原地移动，[可不加判断]
            if (right - left > 1){
                nums[left + 1] = nums[right];
            }
            right++;
            left++;
        }
        return left + 1;
    }

    /**
     * 21 合并2个有序链表
     * O(n) n为 l1,l2中长度最小的
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }

        if (l2 == null){
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode tmp = head;

        while (l1 != null && l2 != null){

            if (l1.val > l2.val){
                tmp.next = l2;
                l2 = l2.next;
            }else{
                tmp.next = l1;
                l1 = l1.next;
            }

            tmp = tmp.next;
        }

        tmp.next = l1 != null ? l1 : l2;
        return head.next;
    }

    /**
     * 88. 合并两个有序数组
     *
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }
        //数组真实尾下标
        int index = m + n - 1;
        n--;
        m--;
        while(n >= 0 && m >= 0){
            if (nums1[m] > nums2[n]){
                nums1[index--] = nums1[m--];
            }else{
                nums1[index--] = nums2[n--];
            }
        }
        for (int i = 0; i <= n; i++){
            nums1[i] = nums2[i];
        }
    }

    /**
     * 1. 两数之和
     */
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        if (len < 2){
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++){

            int cur = nums[i];

            if (map.get(target - cur) == null){
                map.put(cur, i);
                continue;
            }
            return new int[]{i, map.get(target - cur)};
        }
        return new int[]{};
    }

    /**
     * 283. 移动零
     */
    public void moveZeroes(int[] nums) {

        int len = nums.length;

        if(len < 2){
            return;
        }
        int j = 0;
        for (int i = 0; i < len; i++){

            if (nums[i] == 0){
                continue;
            }
            nums[j] = nums[i];

            //防止原地移动赋值
            if (i != j){
                nums[i] = 0;
            }
            j++;
        }
    }

    /**
     * 66. 加一
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int len = digits.length;
        if(len == 0){
            return digits;
        }

        for(int i = len  - 1; i >= 0; i--){
            digits[i]++;
            digits[i] %= 10;

            if(digits[i]  != 0){
                return digits;
            }
        }

        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    /**
     * 242. 有效的字母异位词
     * 解法1 ： hashmap 存储每个字母个数
     * 解法2： 排序 比较
     */
    public boolean isAnagram(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen){
            return false;
        }

        //排序
//        char[] sArr = s.toCharArray();
//        char[] tArr = t.toCharArray();
//        Arrays.sort(sArr);
//        Arrays.sort(tArr);
//        return sArr.equals(tArr);

        //2. map比较
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < sLen; i++){
            char cur = s.charAt(i);
            sMap.put(cur, sMap.getOrDefault(cur, 0) + 1);
        }

        for(int i = 0; i < tLen; i++){
            char cur = t.charAt(i);
            tMap.put(cur, tMap.getOrDefault(cur, 0) + 1);
        }

        return sMap.equals(tMap);
    }


}

