/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.Daily;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/29 2:00 下午
 */
public class 最小路径和 {

    public static void main(String[] args) {
        最小路径和 cl = new 最小路径和();
        int[][] arr = new int[3][3];
        arr[0] = new int[]{1,3,1};
        arr[1] = new int[]{1,5,1};
        arr[2] = new int[]{4,2,1};

        System.out.println(cl.minPathSum(arr));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (i == 0 && j == 0){
                    continue;
                }

                if (i == 0){
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }else if(j == 0){
                     dp[i][j] = dp[i - 1][j] + grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
