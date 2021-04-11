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

}
