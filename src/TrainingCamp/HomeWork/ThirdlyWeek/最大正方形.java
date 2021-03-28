package TrainingCamp.HomeWork.ThirdlyWeek;

/**
 * @author xiaokuo
 * @since 2021/3/28
 * 221
 * https://leetcode-cn.com/problems/maximal-square/
 */
public class 最大正方形 {

    public int maximalSquare(char[][] matrix) {
        //自顶向下
        //递推公式： dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
        int height = matrix.length;
        if(height < 1){
            return 0;
        }
        int with = matrix[0].length;
        int[][] dp = new int[height + 1][with + 1];
        int max = 0;

        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= with; j++){
                if(matrix[i - 1][j - 1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
