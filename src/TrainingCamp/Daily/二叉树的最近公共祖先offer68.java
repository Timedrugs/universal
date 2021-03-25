/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/25 7:49 下午
 */
public class 二叉树的最近公共祖先offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root  == null){
            return null;
        }

        if(root == null || p == root || q == root ){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //根节点
        if(left != null && right != null){
            return root;
        }
        //左为空
        if(left == null){
            return right;
        }
        //右为空
        if(right == null){
            return left;
        }
        return null;
    }
}
