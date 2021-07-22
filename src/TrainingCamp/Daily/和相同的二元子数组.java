/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/7/8 2:44 下午
 */
public class 和相同的二元子数组 {

  public static void main(String[] args) {
    和相同的二元子数组 cl = new 和相同的二元子数组();
//    System.out.println(cl.numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    System.out.println(cl.numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
  }

  public int numSubarraysWithSum(int[] nums, int goal) {
    if (nums.length == 0){
      return 0;
    }
    int left = 0;
    int right = 0, len = nums.length;
    int count = 0, total = 0;
    while (right < len){
      int curR = nums[right];
      total += curR;
      if (total == goal){
        count++;
      }

      //右移
//      if (total < goal){
//        continue;
//      }

      //左移
      while (left < right && (total > goal || ( total == goal && nums[left] == 0))){
        int curL = nums[left];
        left++;
        total -= curL;
        if (goal == total) {
          count++;
        }

        //total 比较大，继续缩小左边界, total 小 ，扩大右边界
      }
      right++;
    }

    return count;
  }

}
