package TrainingCamp.HomeWork.FourthWeek;

/**
 * @author xiaokuo
 * @since 2021/4/4 10:30 下午
 */
public class 省份数量 {

    /**
     * bfs
     * 时间复杂度O(m*n);
     * @param isConnected
     * @return
     *
     * 问题： 和岛屿问题差在那里？？  对角线相连接是同一个省份吗？？？
     */
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;

        if (m == 0){
            return 0;
        }
        int n = isConnected[0].length;
        int res = 0;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++){
            if(!visited[i]){
                dfs(visited, n, i, isConnected);
                res++;
            }
        }
        return res;
    }

    private void dfs(boolean[] visited, int n, int i, int[][] isConnected) {

        for(int j = 0; j < n; j++){
            if(!visited[j] && isConnected[i][j] == 1){
                visited[i] = true;
                dfs(visited, n, j, isConnected);
            }
        }
    }

    //todo  华丽分割线  请助教指导下
//    public int findCircleNum(int[][] isConnected) {
//        int m = isConnected.length;
//
//        if (m == 0){
//            return 0;
//        }
//        int n = isConnected[0].length;
//        int res = 0;
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//
//                if(isConnected[i][j] == 2){
//                    continue;
//                }
//                if (isConnected[i][j] == 1){
//                    dfs(isConnected, i, j);
//                    res++;
//                }
//            }
//        }
//        return res;
//    }
//
//    private void dfs(int[][] isConnected, int i, int j) {
//
//        //判断边界
//        if(i < 0 || i >= isConnected.length || j < 0 || j >= isConnected[0].length ){
//            return ;
//        }
//
//        if (isConnected[i][j] != 1){
//            return;
//        }
//        isConnected[i][j] = 2;
//
//        dfs(isConnected, i - 1, j);
//        dfs(isConnected, i + 1, j);
//        dfs(isConnected, i, j - 1);
//        dfs(isConnected, i, j + 1);
//    }

}
