/*
 * Copyright (c) 2022. 贝壳找房（北京）科技有限公司
 */
package faceProblem.算法;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2022/3/24 8:49 下午
 */
public class 接雨水42 {

  public static void main(String[] args) {
    接雨水42 cl = new 接雨水42();
    int[] arr =  {0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(cl.trap(arr));
  }
  public int trap(int[] height) {
    int ans = 0;
    int size = height.length;
    for (int i = 1; i < size - 1; i++) {
      int max_left = 0, max_right = 0;
      for (int j = i; j >= 0; j--) { //Search the left part for max bar size
        max_left = Math.max(max_left, height[j]);
      }
      for (int j = i; j < size; j++) { //Search the right part for max bar size
        max_right = Math.max(max_right, height[j]);
      }
      ans += Math.min(max_left, max_right) - height[i];
    }
    return ans;
  }

}
