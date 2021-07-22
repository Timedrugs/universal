/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Basic;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/7/6 4:04 下午
 */
public class 二分查找 {

  public static void main(String[] args) {
    System.out.println(findTarget(new int[]{1,2,3}, 111));
  }

  private static int findTarget(int[] arr, int target){
    int len = arr.length;
    if (len == 0){
      return  -1;
    }

    if (len == 1){
      return  target == arr[0] ? 0 : -1;
    }

    int left = 0;
    int right = len - 1;
    while(left <= right){
      int mid = (right + left)/2;
      int cur = arr[mid];
      if (cur == target){
        return mid;
      }

      if(cur > target){
        right = mid - 1;
      }else{
        left = mid + 1;
      }
    }

    return -1;
  }


}
