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

        BinaryTreeCode cl = new BinaryTreeCode();
        cl.traverseTree(cl.constructMaximumBinaryTree(new int[]{3}));
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

    /**
     * 116
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，
     * 则将 next 指针设置为 NULL。
     * //
     * // 初始状态下，所有 next 指针都被设置为 NULL。
     */
    public Node connect(Node root) {
        if (root == null){
            return null;
        }

        connectTwoNode(root.left, root.right);

        return root;
    }
    public void connectTwoNode(Node node1, Node node2){

        if (node1 == null || node2 == null){
            return ;
        }


        node1.next = node2;
        //自己连接
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        connectTwoNode(node1.right, node2.left);
    }

    /**
     * 114 二叉树展开链表
     *
     * 例如，给定二叉树
     * //
     * //     1
     * //   / \
     * //  2   5
     * // / \   \
     * //3   4   6
     * //
     * // 将其展开为：
     * //
     * // 1
     * // \
     * //  2
     * //   \
     * //    3
     * //     \
     * //      4
     * //       \
     * //        5
     * //         \
     * //          6
     */
    public void flatten(TreeNode root) {
        /**
         * 1、将root的左子树和右子树拉平。
         *
         * 2、将root的右子树接到左子树下方，然后将整个左子树作为右子树。
         */

        if (root == null){
            return;
        }

        //1 拉直左右子树
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 2、左右子树已经被拉平成一条链表
        TreeNode left  = root.left;
        TreeNode right = root.right;

        // 3、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 4、将原先的右子树接到当前右子树的末端

        TreeNode tmp = root;
        while (tmp.right != null){
            tmp = tmp.right;
        }

        tmp.right = right;

    }

    /**
     * 654.最大二叉树
     * （难度 Medium）
     * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
     * 二叉树的根是数组 nums 中的最大元素。
     * // 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
     * // 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 0){
            return new  TreeNode();
        }

        if (nums.length == 1){
            return new  TreeNode(nums[0]);
        }

        int start = 0, end = nums.length - 1;
        return buildTree(nums, start, end);
    }
    public TreeNode buildTree(int[] nums, int start, int end){

        if (nums.length == 0){
            return new  TreeNode();
        }
        if (nums.length == 1){
            return new  TreeNode(nums[0]);
        }

        if (end < start){
            return null;
        }

        int index = 0; int maxValue = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++){
             int cur = nums[i];

             if (cur > maxValue){
                 maxValue = cur;
                 index = i;
             }
        }

        TreeNode root = new TreeNode(maxValue);
        root.left     = buildTree(nums, start, index - 1);
        root.right    = buildTree(nums, index + 1, end);
        return  root;
    }



    /**
     * 105.从前序与中序遍历序列构造二叉树
     * （难度 Medium）
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    }


    /**
     * 106.从中序与后序遍历序列构造二叉树
     * （难度 Medium）
     * @return
     */



    public void traverseTree(TreeNode root){

        if (root == null){
            System.out.print("#");
            return;
        }
        //中序遍历
        traverseTree(root.left);
        System.out.print(root.val);
        traverseTree(root.left);
    }

}














