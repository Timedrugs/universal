/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.动态规划;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/29 4:29 下午
 * 337
 */
public class 打家劫舍3 {
    Map<TreeNode, Integer> node = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null){
            return  0;
        }

        if (node.containsKey(root)){
            return node.get(root);
        }
        //本节点+下下节点
        int robCur = root.val
            + (root.left != null ? rob(root.left.left ) + rob(root.left.right) : 0)
            + (root.right != null ? rob(root.right.right) + rob(root.right.left) : 0);

        int rotNext = rob(root.left) + rob(root.right);
        int res = Math.max(robCur, rotNext);
        node.put(root, res);
        return res;
    }

    public int rob(int[] nums) {
        int len = nums.length;
        int[]  dp = new int[len + 1];

        for(int i = len - 1; i >= 0; i--){
            dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[len];
    }
}
