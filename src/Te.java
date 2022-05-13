/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/11/16 11:33 上午
 */
public class Te {

  public static void main(String[] args) {

    Te t = new Te();
    List<Integer> a = t.findSubstring1("barfoothefoobarman", new String[]{"foo","bar"});
    System.out.println(a);
//
//    int a1 = 10;
//    double b1 = 9.9;
//    System.out.println(a1 > b1);
//
//    int[] a = new int[]{10, 88, 3, 6, 22, 11, 2};
//    PriorityQueue<Integer> queue = new PriorityQueue<>(a.length);
//
//    for (int i = 0; i < a.length; i++) {
//      queue.add(a[i]);
//    }
//    while (!queue.isEmpty()) {
//      System.out.println(queue.poll());
//    }
//
//    System.out.println("-------------");
//
//    Employee e1 = new Employee("John", 25);
//    Employee e2 = new Employee("Ace", 22);
//    Employee e3 = new Employee("Keith", 35);
//
//    List<Employee> employees = new ArrayList<>();
//    employees.add(e1);
//    employees.add(e2);
//    employees.add(e3);
//
//    employees = employees
//        .stream()
//        .sorted(Comparator.comparing(Employee::getAge))
//        .collect(Collectors.toList());
//    System.out.println(employees);
  }

  class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> res = new ArrayList<>();
      if (s == null || s.length() == 0 || words == null || words.length == 0) {
        return res;
      }
      HashMap<String, Integer> map = new HashMap<>();
      int one_word = words[0].length();
      int word_num = words.length;
      int all_len = one_word * word_num;
      for (String word : words) {
        map.put(word, map.getOrDefault(word, 0) + 1);
      }
      for (int i = 0; i < s.length() - all_len + 1; i++) {
        String tmp = s.substring(i, i + all_len);
        HashMap<String, Integer> tmp_map = new HashMap<>();
        for (int j = 0; j < all_len; j += one_word) {
          String w = tmp.substring(j, j + one_word);
          tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
        }
        if (map.equals(tmp_map)) {
          res.add(i);
        }
      }
      return res;
    }
  }


  class Solution1 {

    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> res = new ArrayList<>();
      if (s == null || s.length() == 0 || words == null || words.length == 0) {
        return res;
      }
      HashMap<String, Integer> map = new HashMap<>();
      int one_word = words[0].length();
      int word_num = words.length;
      int all_len = one_word * word_num;
      for (String word : words) {
        map.put(word, map.getOrDefault(word, 0) + 1);
      }
      for (int i = 0; i < one_word; i++) {
        int left = i, right = i, count = 0;
        HashMap<String, Integer> tmp_map = new HashMap<>();
        while (right + one_word <= s.length()) {
          String w = s.substring(right, right + one_word);
          right += one_word;
          if (!map.containsKey(w)) {
            count = 0;
            left = right;
            tmp_map.clear();
          } else {
            tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
            count++;
            while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
              String t_w = s.substring(left, left + one_word);
              count--;
              tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
              left += one_word;
            }
            if (count == word_num) {
              res.add(left);
            }
          }
        }
      }
      return res;
    }
  }


  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> wordsMap = new HashMap<String, Integer>();
    for (String word : words) {// 单词表
      Integer num = wordsMap.getOrDefault(word, 0) + 1;
      wordsMap.put(word, num);
    }
    int size = words.length;// 单词表个数
    int wordLen = words[0].length();// 每个单词长度
    int total = wordLen * size;// 单词表总长度, s至少要这么长才有可能是
    List<Integer> ans = new ArrayList<>();
    if (s.length() < total) { // 小于就不可能是
      return ans;// 这里不能返回null ... 坑1
    }
    char[] str = s.toCharArray();
    int strLen = s.length();
    for (int i = 0; i < strLen && i + total <= strLen; i++) {// i + total <= strLen 限制最后的起始位置,不足量的不看了
      String part = new String(str, i, wordLen);// 每一个起始点开始,wordLen的字符串
      Integer num = wordsMap.getOrDefault(part, 0);// 在单词表内的数量
      if (num != 0) {// 说明从i开始的长度wordLen字符串,是目标中一个
        // 看看从i开始total长的字符串是不是都是
        boolean has = this.f(str, i, new HashMap<>(wordsMap), wordLen, total);
        if (has) {
          ans.add(i);
        }
      }
    }
    return ans;
  }

  private boolean f(char[] str, int i, HashMap<String, Integer> hashMap, int wordLen, int total) {
    if (str.length - i + 1 < total) {// 长度不够
      return false;
    }
    for (int j = i; j < i + total && j + wordLen <= i + total; j = j + wordLen) {
      String part = new String(str, j, wordLen);
      Integer num = hashMap.getOrDefault(part, 0);
      if (num == 0) {
        return false;// 单词表中没有了,这段肯定不是
      } else {
        hashMap.put(part, num - 1);// 消除一个单词
      }
    }
    return true;
  }


  public List<Integer> findSubstring1(String s, String[] words) {

    Map<String, Integer> wordsMap = new HashMap<>();
    for (String word : words) {// 单词表
      Integer num = wordsMap.getOrDefault(word, 0) + 1;
      wordsMap.put(word, num);
    }
    int size = words.length;// 单词表个数
    int wordLen = words[0].length();// 每个单词长度
    int total = wordLen * size;// 单词表总长度, s至少要这么长才有可能是
    List<Integer> ans = new ArrayList<>();
    if (s.length() < total) { // 小于就不可能是
      return ans;// 这里不能返回null ... 坑1
    }

    int strLen = s.length();
    for (int i = 0; i < strLen && i + total <= strLen; i++) {// i + total <= strLen 限制最后的起始位置,不足量的不看了

      String part = s.substring(i, wordLen + i);
      Integer num = wordsMap.getOrDefault(part, 0);// 在单词表内的数量

      //存在多次
      if (num > 0) {
        if (check(s, total, i, strLen, wordLen)) {
          ans.add(i);
        }
      }
    }

    return ans;
  }

  private boolean check(String s, int total, int i, int strLen, int wordLen) {
    if (strLen - i + 1 < total) {// 长度不够
      return false;
    }

    Map<String, Integer> windowns = new HashMap<>();
    for (int j = i; j < i + total && j + wordLen <= i + total; j = j + wordLen) {

      String part1 = s.substring(j, wordLen + 1);

      int count = windowns.getOrDefault(part1, 0);

      if (count == 0) {
        return false;
      }

      windowns.put(part1, windowns.get(part1) - 1);
    }
    return true;
  }


  public static class Employee {

    String name;
    int age;

    public Employee(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }
  }

}
