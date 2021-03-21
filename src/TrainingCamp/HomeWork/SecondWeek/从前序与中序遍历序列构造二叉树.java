package TrainingCamp.HomeWork.SecondWeek;

/**
 * @author xiaokuo
 * @since 2021/3/21 
 */
public class 从前序与中序遍历序列构造二叉树 {

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     *
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return  help(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
// preorder 为空，直接返回 null
        if (pStart == pEnd) {
            return null;
        }
        int root_val = preorder[pStart];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - iStart;
        //递归的构造左子树
        root.left = help(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, i_root_index);
        //递归的构造右子树
        root.right = help(preorder, pStart + leftNum + 1, pEnd, inorder, i_root_index + 1, iEnd);
        return root;
    }
}
