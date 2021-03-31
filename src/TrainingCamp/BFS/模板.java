/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import javax.xml.soap.Node;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/31 1:43 下午
 */
public class 模板 {

    //计算start 到 target距离
    public int bfs(Node start, Node target){
        //核心数据结构
        Queue<Node> q = new LinkedList<>();

        //避免走回头路
        Set<Node> visited = new HashSet<>();
        //将起点加入队列
        q.offer(start);
        visited.add(start);
        //记录扩散步数
        int step = 0;

        while (!q.isEmpty()){
            int size = q.size();
            //将当前队列中的所有节点像四周扩散
            for(int i = 0; i < size; i++){
                Node cur = q.poll();

                //重点：这里判断是否到达了终点
                if(cur == target){
                    return step;
                }

                //将cur相邻的节点加入队列,cur.adj()泛指cur相邻的节点，比如说二维数组中，cur上下左右四面的位置就是相邻节点
//                for(Node x : cur.adj()){
//                    if (x not in visited){
//                        q.offer(x);
//                        visited.add(x);
//                    }
//                }
            }
            step++;
        }
        return step;
    }

}
