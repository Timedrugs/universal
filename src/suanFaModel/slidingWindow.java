package suanFaModel;


import java.util.HashMap;

/**
 * @author xiaokuo
 * @since 2021/1/8 12:31 上午
 *
 * url: https://mp.weixin.qq.com/s/ioKXTMZufDECBUwRRp3zaA
 */
public class slidingWindow {

    public static void main(String[] args) {

        System.out.println((new slidingWindow()).minWindow("ADOBECODEBANC", "ABC"));
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
     * 3
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
                int tmpLen = windows.size() - 1;
                res  = tmpLen > res ? tmpLen : res;

                char lCur = s.charAt(left);
                left++;
                windows.put(lCur, windows.getOrDefault(lCur, 0) + 1);
            }
        }

        return  res == Integer.MIN_VALUE ? 0 : res;
    }


    /**
     * 438
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


}
