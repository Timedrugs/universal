/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.StrCode;

import java.util.Stack;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/12/27 8:19 下午
 */
public class 简化路径71 {

  public static void main(String[] args) {
    简化路径71 cl = new 简化路径71();
//    System.out.println(cl.simplifyPath("/a/./b/../../c/"));
    System.out.println(cl.simplifyPath("/../"));
  }


  /**
   * 一开始没看懂题意可能就像我一样，这都说的啥玩意？？黑人问号脸。 其实这道题目要理解的是。Unix 风格的文件路径。
   * <p>
   * '.' 代表的是当前目录本身： 换句话说就是 /a/./b === /a/b 它是可以去掉的 '..'代表的是当前目录的前一个目录： 换句话说就是 /a/b/../c === /a/c 它也是可以去掉的，而且还要把他前面的目录去掉 知道了 上面2点就好做了 第一步： 先以'/' 切割字符串成数组 例如 "/home//foo/../fn" 变成了
   * ['home','','foo','..','fn'] 第二步： 遍历数组； 1. 如果值为 '' 或 '.'就跳过不放入栈 2. 如果值为 '..' 就跳过不放入栈， 并且如果栈有值还要pop() 3. 其他数据就可以直接放入栈中； 最后： 用'/'拼接数组, 注意最前面的‘/’要手动加上；
   * <p>
   * 作者：daomingqian 链接：https://leetcode-cn.com/problems/simplify-path/solution/kan-dong-ti-yi-7xing-dai-ma-gao-ding-by-enr2l/ 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param path
   * @return
   */
  public String simplifyPath(String path) {

    String[] arr = path.split("/");
    Stack<String> stack = new Stack<>();
    for (String s : arr) {
      if (s.equals("") || s.equals(".")) {
        continue;
      }

      if (s.equals("..")) {
        if (stack.size() > 0) {
          stack.pop();
        }
        continue;
      }
      stack.push(s);
    }

    StringBuilder sb = new StringBuilder("/");
    int idx = 1;
    int len = stack.size();
    for (String s : stack) {
      sb.append(s);
      if(idx++ < len){
        sb.append("/");
      }
    }

    return sb.toString();
  }

}
