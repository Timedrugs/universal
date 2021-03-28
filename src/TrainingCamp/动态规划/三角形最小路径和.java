package TrainingCamp.动态规划;

import java.util.List;

/**
 * @author xiaokuo
 * @since 2021/3/28 3:10 下午
 * 120
 * https://leetcode-cn.com/problems/triangle/
 */
public class 三角形最小路径和 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int len = triangle.size();
        if(len == 0){
            return 0;
        }
//        return  dp1(triangle);

        int[] dp = new int[len + 1];

        for (int i = len - 1;i >= 0; i--){
            for (int j = 0;j <=i; j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[len];
    }

    //解法1： 2维
    public int dp1(List<List<Integer>> triangle){
        int len = triangle.size();

        if(len == 0){
            return 0;
        }

        //一维数组即可 第二位坐标通过list.get()
        int[][] dp = new int[len + 1][len + 1];

        for (int i = len - 1; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

}
