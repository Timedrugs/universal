/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.FiveGrug.FirstWeek.SecondWeek;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/19 1:53 下午
 */
public class 验证二叉搜索树98 {

    int min = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        //左子树最大值 < root < 右子树最小值
        if (root == null){
            return true;
        }

        //中序遍历
        if (!isValidBST(root.left)){
            return false;
        }

        if (root.val <=  min){
            return false;
        }

        min = root.val;

        //右子树
        return isValidBST(root.right);

    }
}
