package slidingWindow;

import java.util.HashMap;
/**
 * @author xiaokuo
 * @since 2021/1/8 12:31 上午
 */
public class slidingWindow {

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
}
