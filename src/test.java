/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/4/14 8:02 下午
 */
public class test {

  public static void main(String[] args) {
    List<Integer> integerList = new ArrayList<>();
    integerList.add(3);//autoboxing
    integerList.add(1223);//autoboxing
    int iq = integerList.get(0);//unboxing
    int iq1 = integerList.get(1);//unboxing
    Integer iq2 = integerList.get(1);//unboxing
    System.out.println(iq);
    System.out.println(integerList.get(1));
    System.out.println(integerList.get(1) == 1223);
    System.out.println(iq1 == 1223);
    System.out.println(iq2 == 1223);
    Integer q = 1223;
    System.out.println(iq2 == q);
    System.exit(0);



    Integer f1 = 100;
    Integer f2 = 100;
    Integer f3 = 150;
    Integer f4 = 150;
    Integer f5 = 128;
    Integer f6 = 128;

    System.out.println(f1 == f2);//true
    System.out.println(f3 == f4);//false
    System.out.println(f3.equals(f4) );//
    System.out.println(f5 == (f6) );//
    System.exit(0);
    Set<Long> set = new HashSet<>();
    set.add(1L);
    set.add(2L);
    set.add(1L);
    System.out.println(set);



    BigDecimal a11 = new BigDecimal(22);
    System.out.println(a11.compareTo(new BigDecimal(2)) == 1);

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
    for (int i = 0 ; i < 10; i++){
      Stu stu =  new Stu();
      stu.setName("qwe" + i);
      stu.setId(i);
      stu.setIds(String.valueOf(i));
      stu.setAge(i*10);
      a.add(stu);
    }
    String s = "";
    String collect = a.stream().map(r -> ""+r.getId()).collect(Collectors.joining("-"));
    List<Long> aaa = a.stream().map(r->Long.valueOf(r.getIds())).collect(Collectors.toList());
    System.out.println(aaa);
    System.out.println(".........");
    Stu stu =  new Stu();
    stu.setName("qwe" + 1);
    stu.setId(1);
    stu.setAge(1*11);
    a.add(stu);

//    Map<String, Stu> map = a.stream().collect(Collectors.toMap(i -> i.getName()+i.getId(), i -> i));

    Map<String, List<Stu>> map = a.stream().collect(Collectors.groupingBy(o->o.getId()+o.getName()));
//    a.stream().collect(Collectors.toMap(o->o.getId()+o.getName(),))

    System.out.println(collect);
//    System.out.println(map);
  }

}
