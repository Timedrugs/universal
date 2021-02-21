package suanFaModel.HashMapAndSetCode;

import java.util.*;

/**
 * @author xiaokuo
 * @since 2021/2/17 4:16 下午
 */
public class HashCode {


    public static void main(String[] args) {
        HashCode cl = new HashCode();
//        System.out.println(cl.isAnagram("art", "trr"));
//        System.out.println(cl.isAnagram("a", "ab"));
        System.out.println(cl.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(cl.threeSum(new int[]{0,0,0,0}));
        System.out.println(cl.threeSum(new int[]{-1,0,1,0}));
    }

    /**
     * 242 有效字母的异或
     * 给定两个字符串 s 和 t ，
     * 编写一个函数来判断 t 是否是 s 的字母异位词。
     * //
     */
    public boolean isAnagram(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen){
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i< sLen; i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i< tLen; i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sMap.equals(tMap);
    }

    /**
     * 3数之和  15
     * 给你一个包含 n 个整数的数组 nums，
     *
     *判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重
     * //复的三元组。
     * //
     * // 注意：答案中不可以包含重复的三元组。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3){
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++){

            if (i > 0 && nums[i] == nums[i -1]){
                continue;
            }

            int value = nums[i];
            int left = i + 1, right = len - 1;

            while (left < right){
                int sum = value + nums[left] + nums[right];
                List<Integer> tmp = new  ArrayList<>();

                if (sum > 0){
                    right--;
                    continue;
                }

                if (sum < 0){
                    left++;
                    continue;
                }

                if (sum == 0 ){
                    tmp.add(value);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                }

                while (left + 1 < right && nums[left] == nums[left+1]){
                    left++;
                }

                while (right - 1 > left && nums[right] == nums[right -1]){
                    right--;
                }
                left++;
                right--;
            }
        }

        return  res;
    }
}

