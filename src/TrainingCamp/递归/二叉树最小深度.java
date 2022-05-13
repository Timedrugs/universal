/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.递归;

import TrainingCamp.Daily.二叉树的最近公共祖先offer68;
import java.util.Map;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/22 1:50 下午
 */
public class 二叉树最小深度 {

    /**
     * 111
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     */
    public int minDepth(TreeNode root) {

        //terminator
        if (root == null){
            return 0;
        }
        //dill down
        if (root.left == null){
          return minDepth(root.right) + 1;
        }

        if (root.right == null){
           return minDepth(root.left) + 1;
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
