/*
 * Copyright (c) 2022. 贝壳找房（北京）科技有限公司
 */
package javaBasice;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2022/1/24 2:16 下午
 */
public class MapStudy {


  public static void main(String[] args) {
//    Map<Integer, String> map = new M








    String s = "ssdfas%s";

    String b = String.format(s, "的是非得失");
    String c = String.format(s, "哦哦");

    String[] basicTemplate = new String[]{"城市类型：%s", "开始生效时间：%s"};

    Calendar cal=Calendar.getInstance();
    cal.add(Calendar.DATE,1);//这里改为1
    Date time=cal.getTime();

    System.out.println(time);


    ArrayList<Integer> list = new ArrayList<Integer>();

    list.add(1);  //这样调用 add 方法只能存储整形，因为泛型类型的实例为 Integer

    try {
      list.getClass().getMethod("add", Object.class).invoke(list, "fsfs");

    }catch (Exception e){
      System.out.println(e);
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
