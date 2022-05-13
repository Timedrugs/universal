/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.ArrayCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/4/13 11:57 下午
 */
public class 合并2个无序数组 {

  public static void main(String[] args) {
    List<String> items = new ArrayList<>();
    items.add("A");
    items.add("B");
    items.add("C");
    items.add("D");
    items.add("E");
    String s = "";
//    items.forEach(item->{
//      if("C".equals(item)){
//        System.out.println(item);
//      }
//    });
//    String collect = items.stream().map(r -> "'"+r.getStcd()+"'").collect(Collectors.joining(","));

    System.out.println(s);
    mergeArr(new int[]{1,3,2,2,4,6,9}, new int[]{2,2,9,7,6,7});
  }
  private static int[] mergeArr(int[] arr1, int[] arr2){

    int l1 = arr1.length;
    int l2 = arr2.length;
    int len = Math.min(l1, l2);
    int index1 = 0, index2 = 0, index = 0;
//    int newArr = new int[];
    List<Integer> list = new ArrayList<>();
    while (index1 < l1 && index2 < l2){

      if(arr1[index1] > arr2[index2] ){

        if( !list.contains(arr2[index2])){
          list.add(arr2[index2]);
        }
        index2++;
        continue;
      }
      if(arr1[index1] <= arr2[index2]){
        if (!list.contains(arr1[index1])){
          list.add(arr1[index1]);
        }
        index1++;
      }
    }

    while (index1 < l1){
      if(!list.contains(arr1[index1])){
        list.add(arr1[index1]);
      }
      index1++;
    }

    while (index2 < l2){
      if(!list.contains(arr2[index2])){
        list.add(arr2[index2]);
      }
      index2++;

    }
    System.out.println(list);
//    return list.toArray();

    return new  int[1];
  }

//  private static  int[] mergeArr1(int[] arr1, int[] arr2){
//
//    Arrays.sort(arr1);
//    Arrays.sort(arr2);
//
//
//
//  }

}
