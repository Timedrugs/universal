/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/11/16 11:33 上午
 */
public class Te {

  public static void main(String[] args) {


    System.out.println(1 << 30);
    Te t = new Te();
    System.out.println(t.countBinarySubstrings("0011"));
//    System.out.println(t.topKFrequent(new int[]{1, 2}, 2));
//    System.out.println(t.topKFrequent1(new int[]{1,1,1,2,2,3}, 2));
//    List<Integer> a = t.findSubstring1("barfoothefoobarman", new String[]{"foo","bar"});
//    System.out.println(a);
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

//    int[] arr = new int[]{2,10};
//    System.out.println(t.minNumber(arr));


//    int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
//    System.out.println(t.lc56Merge(arr));

    int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
    System.out.println(t.maxSlidingWindow(arr, 3));

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

  public String minNumber(int[] nums) {

    int len = nums.length;
    if (len < 2) {
      return String.valueOf(nums[0]);
    }
    String[] str = new String[len];
    for (int i = 0; i < len; i++) {
      str[i] = String.valueOf(nums[i]);
    }

    quickSort(str, 0, len - 1);
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < len; i++) {
      sb.append(str[i]);
    }

    return sb.toString();
  }

  private void quickSort(String[] str, int start, int end) {

    if (start >= end) {
      return;
    }
    int i = start;
    int j = end;
    String tmp = str[i];
    while (i < j) {
      while ((str[j] + str[start]).compareTo((str[start] + str[j])) >= 0 && i < j) {
        j--;
      }

      while ((str[i] + str[start]).compareTo((str[start] + str[i])) <= 0 && i < j) {
        i++;
      }

      tmp = str[i];
      str[i] = str[j];
      str[j] = tmp;
    }
    str[i] = str[start];
    str[start] = tmp;
    quickSort(str, start, i - 1);
    quickSort(str, i, end);
  }

  public int[][] lc56Merge(int[][] intervals) {

    //按照第一个数字排序
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
    int len = intervals.length;
    int[][] res = new int[len][2];

    int pre = -1;
    int index = 0;
    for (int i = 0; i < len; i++) {
      int[] cur = intervals[i];
      if (pre < cur[0]) {
        res[index++] = intervals[i];
        pre = cur[1];
      } else {
        pre = Math.max(cur[1], pre);
        res[index - 1][1] = pre;
      }
    }
    return Arrays.copyOfRange(res, 0, index);
  }


  public int[] maxSlidingWindow(int[] nums, int k) {
    int len = nums.length;

    if (len < k) {
      return new int[0];
    }
    int right = 0, valid = 0, index = 0;
    List<Integer> windows = new ArrayList<>();
    int[] res = new int[len - k + 1];

//        while (right < len){
    for (int i = 0; i < len; i++) {
      if (windows.size() == k) {
        windows.remove(0);
      }
//            addList(nums[right], windows);
      addList(nums[i], windows);
      valid++;

      if (valid == k) {
        //放入list
        res[index++] = windows.get(0);
//                if(windows.get(0) == res[right - k + 1]){
        if (windows.get(0) == nums[i - k + 1]) {
          windows.remove(0);
        }
        valid--;
      }
      right++;

    }
    return res;
  }

  private void addList(int num, List<Integer> windows) {
    while (windows.size() > 0 && num > windows.get(windows.size() - 1)) {
      windows.remove(windows.size() - 1);
    }
    windows.add(num);
  }

  private int xxx(String s) {
    char[] chars = s.toCharArray();
    int len = chars.length;
    //1.去空格
    int index = 0;
    while (index < len && chars[index] == ' ')
      index++;
    //2.排除极端情况 "    "
    if (index == len) return 0;
    //3.设置符号
    int sign = 1;
    char firstChar = chars[index];
    if (firstChar == '-') {
      index++;
      sign = -1;
    } else if (firstChar == '+') {
      index++;
    }
    int res = 0, last = 0; //last 记录上一次的res，以此来判断是否溢出
    while (index < len) {
      char c = chars[index];
      if (c < '0' || c > '9') break;
      int tem = c - '0';
      last = res;
      res = res * 10 + tem;
      if (last != res / 10)  ////如果不相等就是溢出了
        return (sign == (-1)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      index++;
    }
    return res * sign;
  }

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    //数组存储
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    //按照map的每个值的次数进行重拍
//     List<List<Integer>> res = new ArrayList<>();
    List<Integer>[] arr = new List[nums.length + 1];

    for (int key : map.keySet()) {
      int index = map.get(key);
      if (arr[index] == null) {
        arr[index] = new ArrayList<>();
      }
      arr[index].add(key);
    }
    int[] ans = new int[k];
    int cnt = 0;
    for (int i = nums.length; i >= 0; i--) {
      if (arr[i] == null) {
        continue;
      }
      while (arr[i].size() > 0) {
        ans[cnt++] = arr[i].remove(arr[i].size() - 1);
        if (cnt == k) {
          break;
        }
      }
    }
    return ans;
  }

  public int[] topKFrequent1(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    //数组存储
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    //最小堆
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      public int compare(Integer a, Integer b) {
        return map.get(a) - map.get(b);
      }
    });

    for (int key : map.keySet()) {
      if(queue.size() < k){
        queue.offer(key);
      }

      if(queue.size() >= k  && map.get(key) > map.get(queue.peek())){
        queue.poll();
        queue.offer(key);
      }

    }
    int[] ans = new int[k];
    int index = 0;
    while (!queue.isEmpty()) {
      ans[index++] = queue.poll();
    }
    return ans;
  }

  public int countBinarySubstrings(String s) {
    int ptr = 0, n = s.length(), last = 0, ans = 0;
    while (ptr < n) {
      char c = s.charAt(ptr);
      int count = 0;
      while (ptr < n && s.charAt(ptr) == c) {
        ++ptr;
        ++count;
      }
      ans += Math.min(count, last);
      last = count;
    }
    return ans;
  }

}
