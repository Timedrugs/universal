/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/31 1:57 下午
 * 111
 */
public class 二叉树最小深度 {

    int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()){

            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.remove(0);

                //终点
                if(cur.left == null && cur.right == null){
                    return depth;
                }

                if (cur.right != null){
                    q.add(cur.right);
                }

                if (cur.left != null){
                    q.add(cur.left);
                }
            }
            depth++;
        }
        return  depth;
    }


    int test(TreeNode root){
        if(root == null){
            return 0;
        }

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int step = 0;

        while(!list.isEmpty()){

            int size = list.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = list.remove(0);
                if(cur.right == null && cur.left == null){
                    return step;
                }

                if(cur.right != null){
                    list.add(cur.right);
                }
                if(cur.left != null){
                    list.add(cur.left);
                }
            }
            step++;
        }
        return step;
    }
}
