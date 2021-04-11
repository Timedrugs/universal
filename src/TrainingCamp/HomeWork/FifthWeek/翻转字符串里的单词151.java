/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.HomeWork.FifthWeek;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since
 *
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 */
public class 翻转字符串里的单词151 {

  public static void main(String[] args) {
    System.out.println();
  }

  public String reverseWords(String s) {
    int left = 0, right = s.length() - 1;
    // 去掉字符串开头的空白字符
    while (left <= right && s.charAt(left) == ' ') {
      ++left;
    }

    // 去掉字符串末尾的空白字符
    while (left <= right && s.charAt(right) == ' ') {
      --right;
    }

    Deque<String> d = new ArrayDeque<String>();
    StringBuilder word = new StringBuilder();

    while (left <= right) {
      char c = s.charAt(left);
      if ((word.length() != 0) && (c == ' ')) {
        // 将单词 push 到队列的头部
        d.offerFirst(word.toString());
        word.setLength(0);
      } else if (c != ' ') {
        word.append(c);
      }
      ++left;
    }
    d.offerFirst(word.toString());

    return String.join(" ", d);
  }
}
