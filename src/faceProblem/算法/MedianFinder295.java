/*
 * Copyright (c) 2022. 贝壳找房（北京）科技有限公司
 */
package faceProblem.算法;

import java.util.PriorityQueue;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2022/4/1 6:45 下午
 */
public class MedianFinder295 {
  //小顶堆
  private PriorityQueue<Integer> small;
  //大顶堆
  private PriorityQueue<Integer> large;
  public MedianFinder295() {

    large = new PriorityQueue<>();
    small = new PriorityQueue<>((a, b) -> {
      return b - a;
    });
  }

  public static void main(String[] args) {
      MedianFinder295 cl = new MedianFinder295();
      //:["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
    //	[[],[1],[2],[],[3],[]]
//    System.out.println(cl.findMedian());
    cl.addNum(1);
    cl.addNum(2);
    System.out.println(cl.findMedian());
    cl.addNum(3);
    System.out.println(cl.findMedian());
  }



  public void addNum(int num) {
    if(small.size() >= large.size()){
      small.add(num);
      large.add(small.poll());
      return;
    }
    large.add(num);
    small.add(large.poll());
  }

  public double findMedian() {
    int sL = small.size();
    int lL = large.size();

    if(sL > lL){
      return (double)small.peek();
    }
    if(lL > sL){
      return (double)large.peek();
    }

    return (double)(small.peek() + large.peek())/2;
  }
}
