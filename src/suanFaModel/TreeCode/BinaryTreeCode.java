/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.TreeCode;


/**
 * TODO Description
 *
 * @author xiaokuo
 * info : https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487126&idx=1&sn=4de13e66397bc35970963c5a1330ce18&chksm=9bd7f09eaca0798853c41fba05ad5fa958b31054eba18b69c785ae92f4bd8e4cc7a2179d7838&scene=21#wechat_redirect
 * @since 2021/1/14 5:55 下午
 */
public class BinaryTreeCode {

    public static void main(String[] args) {

//        System.out.println((new BinaryTreeCode()).invertTree([4,2,7,1,3,6,9]));
    }

    /**
     * The framework
     * 二叉树遍历框架
     */
    public void traverseFramework(TreeNode root){

        //前序遍历
        traverseFramework(root.left);
        //中序遍历
        traverseFramework(root.right);
        //后序遍历
    }

    /**
     *  226 题「翻转二叉树」
     *
     *     4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     *
     * 变成如下
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     */
    public TreeNode invertTree(TreeNode root) {

        if (null == root){
            return root;
        }

        /**** 前序遍历位置 ****/
        // root 节点需要交换它的左右子节点
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 让左右子节点继续翻转它们的子节点
        invertTree(root.right);
        invertTree(root.left);

        return root;
    }

}
