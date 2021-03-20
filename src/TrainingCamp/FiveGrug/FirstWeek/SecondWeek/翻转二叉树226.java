/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.FiveGrug.FirstWeek.SecondWeek;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/19 1:52 下午
 */
public class 翻转二叉树226 {

    public TreeNode invertTree(TreeNode root) {

        if(root == null){
            return root;
        }

        //交换左右子树
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;

    }
}
