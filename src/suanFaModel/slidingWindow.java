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

}
