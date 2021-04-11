/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.HomeWork.FifthWeek;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since
 * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class 翻转字符串里的单词II {

  public String reverseWords(String s) {
    StringBuffer ret = new StringBuffer();
    int length = s.length();
    int i = 0;
    while (i < length) {
      int start = i;
      while (i < length && s.charAt(i) != ' ') {
        i++;
      }
      for (int p = start; p < i; p++) {
        ret.append(s.charAt(start + i - 1 - p));
      }
      while (i < length && s.charAt(i) == ' ') {
        i++;
        ret.append(' ');
      }
    }
    return ret.toString();
  }

}
