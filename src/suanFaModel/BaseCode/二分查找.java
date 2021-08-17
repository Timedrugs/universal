/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.BaseCode;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/8/3 3:52 下午
 */
public class 二分查找 {

  public static void main(String[] args) {
    int[] arr = new int[]{1,4,6,7,8,11,44};
    int a = findTarget(arr, 10);
    System.out.println(a);
  }

  private static int findTarget(int[] arr, int target) {
      int len = arr.length;

      int left = 0;
      int right = len;
      while (left < right){
        int mid = (right + left)/2;

        int cur = arr[mid];
        if (cur == target){
          return mid;
        }

        if (cur < target){
          left = mid + 1;
        }else{
          right = mid;
        }

      }
    return  -1;
  }

}
