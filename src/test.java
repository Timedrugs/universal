/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/4/14 8:02 下午
 */
public class test {

  public static void main(String[] args) {

    int nums = 1231;
    String qq = String.valueOf(nums);
    qq.length();
    qq.charAt(1);
    System.out.println(String.valueOf(nums));
//      System.out.println('i' - '1');
//      String.join();
    test cl = new test();
    int[] arr1 = {1,2,3,4};
    int[] arr2 = {5,6,7};
    System.out.println("-------------1");
    int[] ints = cl.mergeArr(arr1, arr2);
    for (int i : ints){
      System.out.println(i);
    }
    System.out.println("-------------2");
//
//    System.out.println(cl.jump(new int[]{2,3,1,1,4}));
//
//    String encode1 = cl.encode("qwe");
//    String encode2 = cl.encode("wqe");
//    System.out.println(encode1.equals(encode2));
////      System.out.println(cl.largestNumber(new int[]{10,2}));
//    System.out.println(cl.myAtoi("21474836460"));
//    System.out.println(cl.myAtoi("+"));
//    System.out.println(cl.myAtoi("1"));
//    System.out.println(cl.myAtoi("-1"));
//    System.out.println(cl.myAtoi("   -42"));
//    System.out.println(cl.myAtoi("   -188888888888"));
//    System.out.println(cl.myAtoi("   188888888888"));
//    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
//    ArrayList<String> list = new ArrayList<>();
////      list.contains() O(n)
//    int num1 = 10;
//    long num2 = 10L;
//    double num3 = 10.0;
//    System.out.println(num2 == num1);
//    System.out.println(num3 == num1);
//    System.out.println(num3 == num2);
//
//    System.out.println(2 >> 1);
//    System.out.println((2 >> 1) & 1);
//    System.out.println(4 >> 1);
//    System.out.println((4 >> 1) & 1);
//
//
//    int xx = 2147483647;
//    long xxx = Long.MAX_VALUE;
//    System.out.println(xx > xxx);
//
//
//    List<Integer> qa = new ArrayList<>();
//    qa.add(1);
//    qa.add(2);
//    qa.add(3);
//    qa.forEach(i -> {
////      qa.remove(i);
//      System.out.println(qa.toString());
//    });
//
//    Iterator<Integer> iterator = qa.iterator();
//    while (iterator.hasNext()) {
//      int next = iterator.next();
//      System.out.println("a:" + next);
//
//      iterator.remove();
////      iterator.remove(next);
//      System.out.println("b:" + next);
//    }
//
//
//    System.out.println(BigDecimal.valueOf(81703).divide(new BigDecimal(100)).toString());
//    Map<Integer, Integer> map111 = new HashMap<>();
//
////    map111.putIfAbsent()
//    System.out.println(map111.containsKey(1));
//
//    BigDecimal brandRate = BigDecimal.valueOf(0.030000);
//    if (brandRate.compareTo(BigDecimal.ZERO) == 0) {
//      System.out.println(0);
//      return;
//    }
//
//    Long cpsAmount = 0L;
//    Long remainAmount = 2723436L - Optional.ofNullable(cpsAmount).orElse(0L);
//
//    long a111122 = brandRate
//            .multiply(BigDecimal.valueOf(remainAmount))
//            .setScale(2, RoundingMode.DOWN)
//            .longValue();
//
//    System.out.println(a111122);
//
//
//    System.out.println(12 == 123);
//    System.out.println(1299 == 1299);
//
//    char[] a1111 = new char[]{'2', '3'};
//    System.out.println(a1111[0]);
//
//    String s11 = "sdsfds fdsf fsd";
//    String[] a22 = s11.split(" ");
//    System.out.println(a22
//    );
//    String s123 = "qwe";
//    System.out.println(s123.charAt(0));
//    String[] tet = s123.split("");
//    System.out.println(tet);
//
//    Calendar cal = Calendar.getInstance();
////      cal.add(Calendar.DATE,1);//这里改为1
//    Date time = cal.getTime();
//    String ccc = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(time);
//    System.out.println(ccc);
//
//    List<Integer> integerList = new ArrayList<>();
//    integerList.add(3);//autoboxing
//    integerList.add(1223);//autoboxing
//    int iq = integerList.get(0);//unboxing
//    int iq1 = integerList.get(1);//unboxing
//    Integer iq2 = integerList.get(1);//unboxing
//    System.out.println(iq);
//    System.out.println(integerList.get(1));
//    System.out.println(integerList.get(1) == 1223);
//    System.out.println(iq1 == 1223);
//    System.out.println(iq2 == 1223);
//    Integer q = 1223;
//    System.out.println(iq2 == q);
//    System.exit(0);
//
//
//    Integer f1 = 100;
//    Integer f2 = 100;
//    Integer f3 = 150;
//    Integer f4 = 150;
//    Integer f5 = 128;
//    Integer f6 = 128;
//
//    System.out.println(f1 == f2);//true
//    System.out.println(f3 == f4);//false
//    System.out.println(f3.equals(f4));//
//    System.out.println(f5 == (f6));//
//    System.exit(0);
//    Set<Long> set = new HashSet<>();
//    set.add(1L);
//    set.add(2L);
//    set.add(1L);
//    System.out.println(set);
//
//
//    BigDecimal a11 = new BigDecimal(22);
//    System.out.println(a11.compareTo(new BigDecimal(2)) == 1);

//    SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
//    String s11= "2011-07-09 00:01:00";
//    try {
//      Date date =  formatter.parse(s11);
//      System.out.println(date);
//
//    }catch (Exception e){
//      System.out.println(e.getMessage());
//    }
//
//
//    BigDecimal a1 = new BigDecimal(100);
//    BigDecimal b = new BigDecimal(34000);
//    BigDecimal c = new BigDecimal(782);
//
//    BigDecimal rate = a1.divide(b, 8 , RoundingMode.HALF_UP);
//    System.out.println(rate.multiply(c).setScale(2, RoundingMode.HALF_UP).longValue());
////    System.out.println(Long.valueOf("11-33-44"));
//    String s1 = "11-33-44";
//    String[] strarray=s1.split("-");
//    System.out.println(Arrays.toString(strarray));
////    System.out.println(false && false);
////    String qq = "-11234";
////    System.out.println(new Date(0));
////    System.out.println(Long.valueOf(qq));
////    BigDecimal amount = new BigDecimal(22);
//////    amount.mul(1.252, 2, RoundingMode.HALF_UP);
////
////    System.out.println(amount);
////    long a1 = 10L;
////    long b = 60L;
////    double f1 = new BigDecimal((float)a1/b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
////    System.out.println(f1);
////    System.out.println(bg);

    List<Stu> a = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      Stu stu = new Stu();
      stu.setName("qwe" + i);
      stu.setId(i);
      stu.setIds(String.valueOf(i));
      stu.setAge(i * 10);
      a.add(stu);
    }
    String s = "";
    String collect = a.stream().map(r -> "" + r.getId()).collect(Collectors.joining("-"));
    List<Long> aaa = a.stream().map(r -> Long.valueOf(r.getIds())).collect(Collectors.toList());
    System.out.println(aaa);
    System.out.println(".........");
    Stu stu = new Stu();
    stu.setName("qwe" + 1);
    stu.setId(1);
    stu.setAge(1 * 11);
    a.add(stu);

//    Map<String, Stu> map = a.stream().collect(Collectors.toMap(i -> i.getName()+i.getId(), i -> i));

    Map<String, List<Stu>> map = a.stream().collect(Collectors.groupingBy(o -> o.getId() + o.getName()));
//    a.stream().collect(Collectors.toMap(o->o.getId()+o.getName(),))

    System.out.println(collect);
//    System.out.println(map);
  }


  private Stack<Integer> stack = new Stack<>();
  private Stack<Integer> minStack = new Stack<>();


  public void push(int val) {
    stack.push(val);

    if (!minStack.isEmpty() && minStack.peek() > val) {
      minStack.push(val);
    }
  }

  public void pop() {
    int val = stack.pop();
    if (!minStack.isEmpty() && minStack.peek() == val) {
      minStack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }

  public int testSynchronized() {

    synchronized (this) {
      System.out.println(111);
    }

    return 1;
  }


  public String largestNumber(int[] nums) {
    int len = nums.length;
    if (len < 1) {
      return "";
    }

    String[] str = new String[len];
    for (int i = 0; i < len; i++) {
      str[i] = nums[i] + "";
    }
    Arrays.sort(str, (a, b) -> {
      String s1 = a + b, s2 = b + a;
      return s2.compareTo(s1);
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      if (str[i] == "0" && i > 0 && str[i].equals(str[i - 1])) {
        continue;
      }
      sb.append(str[i]);
    }
    return sb.substring(3);
  }

  public int myAtoi(String s) {
    int len = s.length();
    if (len == 0) {
      return 0;
    }
    char[] charArr = s.toCharArray();
    int index = 0;

    //丢弃前导空格
    while (index < len && charArr[index] == ' ') {
      index++;
    }
    if (index == len) {
      return 0;
    }

    //判断正负号
    int sign = 1;
    char cur = charArr[index];
    if (cur == '-') {
      sign = -1;
      index++;
    } else if (cur == '+') {
      index++;
    }
    int ans = 0;
    int last = 0;
    while (index < len) {
      cur = charArr[index++];
      //非【1,9】跳出
      if (cur > '9' || cur < '0') {
        break;
      }
      //是否越界了[−231,  231 − 1]
      last = ans;
      ans = ans * 10 + (cur - '0');
      ////如果不相等就是溢出了
      if (last != ans / 10) {
        return (sign == (-1)) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }
    }
    return sign * ans;
  }

  private String encode(String s1){
    char[] code = new char[26];
    for (char c : s1.toCharArray()) {
      int delta = c - 'a';
      code[delta]++;
    }
//    System.out.println(code.toString());
//    System.out.println(new String(code));
//    return code.toString();
    return new String(code);
  }

  public int jump(int[] nums) {
    int n = nums.length;
    int end = 0, farthest = 0;
    int jumps = 0;
    for (int i = 0; i < n - 1; i++) {
      farthest = Math.max(nums[i] + i, farthest);
      if (end == i) {
        jumps++;
        end = farthest;
      }
    }
    return jumps;
  }
//  合并两个有序数组为一个有序数组
//  arr1=[1,2,3,4]
//          arr2=[5,6,7]
//  result=[1,2,3,4,5,6,7】
  private int[] mergeArr(int[] arr1, int[]arr2){

    int l1 = arr1.length, l2 = arr2.length;
    int index1 = 0, index2 = 0, index = 0;
    int[] newArr = new int[l1 + l2];
    while(index1 < l1 && index2 < l2){
      //防止错误使用
      int cur1 = arr1[index1];
      int cur2 = arr2[index2];
      if(cur1 < cur2){
        newArr[index++] = cur1;
        index1++;
      }else{
        newArr[index++] = cur2;
        index2++;
      }
    }

    while (index1 < l1){
      newArr[index++] = arr1[index1++];
    }
    while (index2 < l2){
      newArr[index++] = arr2[index2++];
    }
    return  newArr;
  }
}
