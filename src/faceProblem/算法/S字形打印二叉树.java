package faceProblem.算法;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaokuo
 * @since 2021/4/7 11:00 下午
 * <p>
 * bfs
 */
public class S字形打印二叉树 {

    public static void main(String[] args) {
        int i = 1,j = 3;
        System.out.println(5>>1);
        int[] n1 = new int[]{1,2,3};
        System.out.println(n1.length);

        //1---1  2---10  3----11  0----0
        System.out.println(1&1);//1
        System.out.println(2&1);//0
        System.out.println(0&1);//0
        System.out.println(3&1);//1
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }
        //dfs
        dfs(res, root, 0);
        return res;

        //bfs
        // bfs(root, res);
        // return res;
    }

    private void dfs(List<List<Integer>> res, TreeNode root, int level){

        if(root == null){
            return;
        }

        if(res.size() == level){
            res.add(new ArrayList<>());
        }

        //第一层
        if((level & 1) == 1){
            res.get(level).add(0, root.val);

        }else{
            res.get(level).add(root.val);
        }

        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrderTest(TreeNode root){
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null){
            return ret;
        }


        dfsTest(ret, 0, root);
        return ret;
    }

    private void dfsTest(List<List<Integer>> ret, int level, TreeNode root) {
        if (root == null){
            return;
        }


        if ((level & 1) == 1){
            ret.get(level).add(0, root.val);
        }else{
            ret.get(level).add(root.val);
        }

        dfsTest(ret, level+1, root.left);
        dfsTest(ret, level+1, root.right);

    }


}
