/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.BaseCode;

import java.util.Arrays;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/8/3 3:52 下午
 */
public class 快拍 {

  public static void main(String[] args) {
    int[] arr = new int[]{99,3,1,66,34,2,88,5,193};
    quickSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static void quickSort(int[] arr) {

    if (arr.length <= 2){
      return;
    }
    int[] a =quickSortHandle(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(a));
  }

  private static int[] quickSortHandle(int[] arr, int i, int i1) {

    if (i1 >= i){
      return arr;
    }

    int low = i, high = i1;

    int mid = arr[i];

    while (low < high){

      while (low < high && mid <= arr[high]){
        high--;
      }

      while (low < high && mid >= arr[low]){
        low++;
      }

      //高低水位换位置
      int tmp = arr[high];
      arr[high] = arr[low];
      arr[low] = tmp;
    }

    arr[i] = arr[low];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
    arr[low] = mid;
    quickSortHandle(arr, i, low - 1);
    quickSortHandle(arr, high + 1, i1);

    return arr;
  }

}
