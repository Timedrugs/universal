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

}
