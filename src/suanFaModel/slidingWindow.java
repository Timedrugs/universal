package suanFaModel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author xiaokuo
 * @since 2021/1/8 12:31 上午
 *
 * url: https://mp.weixin.qq.com/s/ioKXTMZufDECBUwRRp3zaA
 */
public class slidingWindow {

    public static void main(String[] args) {

        System.out.println((new slidingWindow()).minWindow("ADOBECODEBANC", "ABC"));
        System.out.println((new slidingWindow()).lengthOfLongestSubstring("abcabcbb"));
        System.out.println((new slidingWindow()).findAnagrams("baa", "aa"));
        System.out.println((new slidingWindow()).checkInclusion("hello", "ooolleoooleh"));
    }


    /**
     * 模板
     */
    public void model(String s, String t){

        // 滑动窗口中字符出现的次数
        HashMap<Character, Integer> windows = new HashMap<>();

        // 字符需要出现的次数
        HashMap<Character, Integer> need = new HashMap<>();

        int tLen = t.length();
        for(int i = 0; i < tLen; i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0, valid = 0;
        int sLen = s.length();
        while (right < sLen){

            char cRight = s.charAt(right);

            // 如果满足条件就将 c移入窗口中，并进行窗口内数据的一系列更新
//            if(...)
//        	...
            right++;

            // 判断左侧窗口是否要收缩
//            while (window needs shrink) {
                // d 是将移出窗口的字符
//                char d = s.charAt(left);
                // 如果满足一定条件，进行窗口内数据的一系列更新，使得退出这个 while循环
//                if(...)
//            	...
                // 左移窗口
//                left++;
//            }

        }
    }

    /**
     * 最长子序列 76.
     *
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     *
     */
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() ==0 ){
            return  "";
        }

        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        int tLen = t.length();
        for (int i = 0 ; i < tLen; i++){
            char currT = t.charAt(i);
            needs.put(currT, needs.getOrDefault(currT, 0) + 1);
        }
        int sLen = s.length();
        int valid = 0;
        int right = 0, left = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        while(right < sLen){

            char rCurr = s.charAt(right);
            right++;

            if (needs.containsKey(rCurr)){
                windows.put(rCurr, windows.getOrDefault(rCurr, 0) + 1);
                if (windows.get(rCurr) == needs.get(rCurr)){
                    valid++;
                }
            }

            while (valid == needs.size()){
                char lCurr =  s.charAt(left);

                if (right - left < len){
                    len = right - left;
                    start = left ;
                }
                left++;

                if (needs.containsKey(lCurr)){
                   int windowsValue =  windows.get(lCurr);

                   if (windowsValue == needs.get(lCurr)){
                       valid--;
                   }

                   windows.put(lCurr, --windowsValue);
                }
            }
        }

        return len < Integer.MAX_VALUE ? s.substring(start, start + len) : "";
    }

    public String minWindowV1(String s, String t) {
        // 发现字符串的题 很多情况都是找子串问题
        // 问题：如何从字符串中找到目标子串
        // 滑动窗口
        // 方法：整型数组存放 Char， Char 的 int 值范围为 0 ~ 127
        // 利用数组 window 存放窗口中字符个数
        // 利用数组 need 存放匹配子串中需要的字符个数

        // 如果字符串为空，或者长度小于需要匹配的长度
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];

        // 窗口中已经匹配的字符个数
        int count = 0;
        int left = 0;
        int right = 0;
        int minLength = s.length();
        String minString = "";

        // need 初始化
        for(int i = 0; i < t.length(); i ++ ){
            need[t.charAt(i)] ++;
        }

        while(right < s.length()){
            char ch = s.charAt(right);
            window[ch] ++;
            // 如果需要该字符，并且已有窗口内的字符个数 小于需要的字符个数
            if(need[ch] > 0 && need[ch] >= window[ch]){
                count ++;
            }

            // 当需要的字符都已经包含在窗口中后，开始收缩 left
            while(count == t.length()){
                ch = s.charAt(left);
                // 当需要删除的字符，是必须留在窗口内时
                if(need[ch] > 0 && need[ch] == window[ch]){
                    count --;
                }
                // 这边需要取 = ，因为可能一开始两个字符串就是匹配的，如 a , a return a
                if(right - left + 1 <= minLength){
                    minLength = right - left + 1;
                    minString = s.substring(left, right + 1);
                }
                window[ch] --;
                left ++;
            }
            right ++;
        }

        return minString;
    }

    /**
     * 最长子串 的长度  3
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 输入: s = "abcabcbb"
     * //输出: 3
     * //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 输入: s = "pwwkew"
     * //输出: 3
     * //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();

        if(len < 2){
            return len;
        }

        int res = Integer.MIN_VALUE;
        HashMap<Character, Integer> windows = new HashMap<>();

        int right = 0, left = 0;

        while (right < len){

            char rCur = s.charAt(right);

            windows.put(rCur, windows.getOrDefault(rCur, 0) + 1);

            right++;

            while (windows.get(rCur) > 1){


                char lCur = s.charAt(left);
                left++;

                windows.put(lCur, windows.getOrDefault(lCur, 1) - 1);

                if (windows.get(lCur) == 0){
                    windows.remove(lCur);
                }
            }
            int tmpLen = windows.size();
            res  = tmpLen > res ? tmpLen : res;
        }

        return  res == Integer.MIN_VALUE ? 0 : res;
    }


    /**
     * 438
     * 题解：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
     * //给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     * //
     * // 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     * //
     * // 说明：
     * //
     * //
     * // 字母异位词指字母相同，但排列不同的字符串。
     * // 不考虑答案输出的顺序。
     *
     * //输入:
     * //s: "cbaebabacd" p: "abc"
     * //
     * //输出:
     * //[0, 6]
     * //
     * //解释:
     * //起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * //起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     * //
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> needs   = new HashMap<>();

        int pLen = p.length();
        for (int i = 0; i < pLen; i++){
            char cur = p.charAt(i);
            needs.put(cur, needs.getOrDefault(cur, 0) + 1);
        }

        int right = 0;
        int left  = 0;
        int valid = 0;
        int sLen  = s.length();

        while (right < sLen){

            char rCur = s.charAt(right);

            if (needs.containsKey(rCur)){

                windows.put(rCur, windows.getOrDefault(rCur, 0) + 1);

                if (windows.get(rCur) == needs.get(rCur)){
                    valid++;
                }
            }

            while (valid == needs.size()){

                if (right - left + 1 == pLen){
                    res.add(left);
                }

                char lChar = s.charAt(left);
                left++;

                if (needs.containsKey(lChar)){
//                    windows.put(rCur, windows.getOrDefault(rCur, 0) - 1);

                    int windowsValue  = windows.get(lChar);
                    if(windowsValue == needs.get(lChar)){
                        valid--;
                    }

                    windows.put(lChar, --windowsValue);
                }
            }

            right++;
        }

        return  res;
    }

    /**
     *567
     *
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * //
     * // 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     * //
     * // 示例1:
     * //
     * //
     * //输入: s1 = "ab" s2 = "eidbaooo"
     * //输出: True
     * //解释: s2 包含 s1 的排列之一 ("ba").
     * //
     */
    public boolean checkInclusion(String s1, String s2) {

        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len == 0 && s2Len == 0){
            return true;
        }

        if(s1Len > s2Len){
            return false;
        }

        if (s1Len == 0 || s2Len == 0){
            return false;
        }

        HashMap<Character, Integer> windows = new HashMap<>();
        HashMap<Character, Integer> needs   = new HashMap<>();

        for (int i = 0; i < s1Len; i++){
            char cur = s1.charAt(i);
            needs.put(cur, needs.getOrDefault(cur, 0) + 1);
        }

        int right = 0,left = 0, valid = 0;

        while(right < s2Len){
            char rCur = s2.charAt(right);

            if (needs.containsKey(rCur)){

                windows.put(rCur, windows.getOrDefault(rCur, 0) + 1);

                if (windows.get(rCur).equals(needs.get(rCur))){
                    valid++;
                }
            }

            while (valid == needs.size()){
                if(right - left + 1 == s1.length()){
                    return  true;
                }

                char lCur = s2.charAt(left);
                if (needs.containsKey(lCur)){

                    int windowsValue = windows.get(lCur);
                    if (needs.get(lCur).equals(windowsValue)){
                        valid--;
                    }

                    windows.put(lCur, --windowsValue);
                }
                left++;
            }

            right++;
        }

        return  false;
    }

    /**
     * 209
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * //输出：2
     *
     * 4+3 = 7
     *
     * Related Topics 数组 双指针 二分查找
     */



    /**
     * 1209
     *
     * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
     * //
     * // 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
     *
     *
     *  输入：s = "deeedbbcccbdaa", k = 3
     * //输出："aa"
     * //解释：
     * //先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
     * //再删除 "bbb"，得到 "dddaa"
     * //最后删除 "ddd"，得到 "aa"
     */
}
