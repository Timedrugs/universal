/*
 * Copyright (c) 2022. 贝壳找房（北京）科技有限公司
 */

import com.sun.deploy.util.StringUtils;
import java.util.Arrays;
import sun.security.util.ArrayUtil;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2022/2/15 8:08 下午
 */
public class Le557 {

  public static void main(String[] args) {
    Le557 cl = new Le557();
    System.out.println(cl.reverseWords("Let's take LeetCode contest"));
  }

  public String reverseWords(String s) {
    //str to arr
    String[] strArr = s.split(" ");

    StringBuilder sb = new StringBuilder();
    int index = 1;
    int len = strArr.length;
    for(String str: strArr){
      String tmp =  swap(str);
      sb.append(tmp);
      if(index++ < len){
        sb.append(" ");
      }
    }

    return sb.toString();
  }

  private String swap(String str){
    int len = str.length();

    String[] sA = str.split("");
    int left = 0, right = len - 1;
    while(left < right){
      String tmp =  sA[left];
      sA[left++] = sA[right];
      sA[right--] = tmp;

    }
    return String.join("",sA);

  }

}
