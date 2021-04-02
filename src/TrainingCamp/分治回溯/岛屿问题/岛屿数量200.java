/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.分治回溯.岛屿问题;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/4/2 1:29 下午
 * https://leetcode-cn.com/problems/number-of-islands/
 * https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-shu-liang-by-leetcode/
 */
public class 岛屿数量200 {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // if(grid[i][j] == '2'){
                //     continue;
                // }
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j){

        //超过边界
        if(!borderOver(grid, i, j)){
            return;
        }

        //不是岛屿
        if(grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 2;
//        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    private boolean borderOver(char[][] grid, int i, int j){
        int i1 = grid.length;
        int j1 = grid[0].length;

        return 0 <= i && i <i1 && j >= 0 && j < j1;
    }

}










