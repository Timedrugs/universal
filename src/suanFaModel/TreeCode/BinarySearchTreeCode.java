package suanFaModel.TreeCode;

/**
 * 二叉搜索树
 *
 * @author xiaokuo
 * @since 2021/1/23 10:19 下午
 */
public class BinarySearchTreeCode {

    //第一期：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247488101&idx=1&sn=6041ddda5f20ccde8a7036d3e3a1482c&chksm=9bd7ec6daca0657b2ab20a936437e2c8206384c3b1485fe91747ad796fa3a5b08556b2f4911e&scene=178&cur_album_id=1318892385270808576#rd

    /**
     * 从做算法题的角度来看 BST，除了它的定义，还有一个重要的性质：BST 的中序遍历结果是有序的（升序）。
     * <p>
     * 也就是说，如果输入一棵 BST，以下代码可以将 BST 中每个节点的值升序打印出来：
     */
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历代码位置
        System.out.println(root.val);
//        print(root.val);
        traverse(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTreeCode cl = new BinarySearchTreeCode();
//        TreeNode root = new TreeNode(2147483647);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(cl.isValidBST(root));
       int[] a = new int[]{};
    }


    /**
     *  230 题「二叉搜索树中第K小的元素
     */
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k == 0){
            return 0;
        }
        int ans = 0;
        dfs(root, k, ans);
        return  ans;
    }

    private void dfs(TreeNode root, int k, int ans) {

        if(root == null){
            return;
        }

        dfs(root.left, k--, ans);
        if(k == 0){
            ans = root.val;
            return;
        }
        dfs(root.right, k--, ans);
    }

    /**
     * 98 验证二叉搜索树
     * 时间复杂度O(n)
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    /**
     * 236
     * 二叉树的最近公共祖先
     * O(n)
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left =  lowestCommonAncestor(root.left, p, q);
        TreeNode right =  lowestCommonAncestor(root.right, p, q);

        if (left == null){
            root = right;
        }

        if (right == null){
            root = left;
        }

        return root;
    }

    /**
     * 235
     * 二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor235(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == q || root == p){
            return root;
        }

        // 左最大值 < root  右最小值 > root
        if (root.val < q.val && root.val < p.val){
            return  lowestCommonAncestor235(root.right, p, q);
        }

        if (root.val > q.val && root.val > p.val){
            return lowestCommonAncestor235(root.left, p, q);
        }

        return root;
    }

    /**
     *  二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
     * //搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
     */
    private TreeNode head, tail;
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null){
            return null;
        }

        head = new TreeNode(-1);
        tail = head;
        inOrder(root);
        return head.right;
    }
    private  void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        //中序遍历
        inOrder(root.left);
        //左子树放到右子树上
        tail.right = root;
        tail = root;
        tail.left = null;
        inOrder(root.right);
    }

}
















