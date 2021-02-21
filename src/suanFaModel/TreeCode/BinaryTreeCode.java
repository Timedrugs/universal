/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel.TreeCode;


import apple.laf.JRSUIUtils.Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 二叉树
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
        return buildTree654(nums, start, end);
    }
    public TreeNode buildTree654(int[] nums, int start, int end){

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
        root.left     = buildTree654(nums, start, index - 1);
        root.right    = buildTree654(nums, index + 1, end);
        return  root;
    }



    /**
     * 105.从前序与中序遍历序列构造二叉树
     * （难度 Medium）
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487270&idx=1&sn=2f7ad74aabc88b53d94012ceccbe51be&chksm=9bd7f12eaca078384733168971147866c140496cb257946f8170f05e46d16099f3eef98d39d9&scene=178&cur_album_id=1318892385270808576#rd
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || preorder.length == 0){
            return null;
        }
        return buildTree105(preorder, 0, preorder.length - 1, inorder, 0, inorder.length -1);
    }
    public TreeNode buildTree105(int[] preorder, int preStart, int preEnd,
                                 int[] inorder, int inStart, int inEnd){
        if (preStart > preEnd){
            return  null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int index  = 0;

        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == preorder[preStart]){
                index = i;
                break;
            }
        }

        int leftLen = index - inStart;
        root.left = buildTree105(preorder, preStart + 1, leftLen + preStart ,inorder, inStart, index - 1);
        root.right = buildTree105(preorder, leftLen + preStart + 1, preEnd,inorder, index + 1, inEnd);

        return root;
    }
    public TreeNode buildTreeV1(int[] preorder, int[] inorder) {
        if (preorder.length == 0){
            return  null;
        }

        if (preorder.length == 1){
            return new TreeNode(preorder[0]);
        }

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return helper(preorderList, inorderList);
    }
    private TreeNode helper(List<Integer> preList, List<Integer> indorList){
        if (indorList.size() == 0){
            return  null;
        }

        int value = preList.remove(0);

        TreeNode root = new TreeNode(value);

        int mid = indorList.indexOf(value);

        //左子树  0 mid
        //[0，mid)是左子树的所有值，inorderList.subList(0, mid)表示截取inorderList
        //的值，截取的范围是[0，mid)，包含0不包含mid。
        root.left =  helper(preList, indorList.subList(0, mid));
        //    root.left = helper(preList, indorList.subList(0, mid));
        // 右子树
        //[mid+1，inorderList.size())是右子树的所有值，
        // inorderList.subList(mid + 1, inorderList.size())表示截取inorderList
        //的值，截取的范围是[mid+1，inorderList.size())，包含mid+1不包含inorderList.size()。
        root.right = helper(preList, indorList.subList(mid + 1, indorList.size()));
        return  root;

    }


    /**
     * 106.从中序与后序遍历序列构造二叉树
     * （难度 Medium）
     * @return
     */
    public TreeNode buildTree106(int[] inorder, int[] postorder) {

        if (inorder.length <= 1){
            return null;
        }

        int len = inorder.length;
        List<Integer> inList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < len ; i++){
            inList.add(inorder[i]);
            postList.add(postorder[i]);
        }
        return helper106(inList, postList);

    }
    private TreeNode helper106(List<Integer> inList, List<Integer> postList){

        if (inList.size() == 0){
            return null;
        }

        int rootV = postList.get(postList.size() - 1);
        TreeNode root = new TreeNode(rootV);

        int index = inList.indexOf(rootV);

        //左子树  [0，mid)
        root.left = helper106(inList, postList.subList(0, index));
        root.right = helper106(inList, postList.subList(index, postList.size() - index));
        return root;
    }


    /**
     * 652 题「寻找重复子树」：
     * @param root
     * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487527&idx=1&sn=9cf2b0d8608ba26ea7c6a5c9b41d05a1&chksm=9bd7ee2faca0673916bf075539bf6fc3c01f3dcc0b298b3f507047692ef5c850ed9cfe82e4e6&scene=178&cur_album_id=1318896187793260544#rd
     */
    HashMap<String, Integer> subStrings = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        traverse652(root);
        return res;
    }
    public String traverse652(TreeNode root){
        if (root == null){
            return "#";
        }

        String  left = traverse652(root.left);
        String right = traverse652(root.right);

        String subString = left + ":"+ right + ":" + root.val;

        int subNums = subStrings.getOrDefault(subString, 0);

        if (subNums == 1){
            res.add(root);
        }

        subStrings.put(subString, ++subNums);
        return subString;
    }



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

























