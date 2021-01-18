package suanFaModel.TreeCode;

/**
 * @author xiaokuo
 * @since 2021/1/15 12:56 上午
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
