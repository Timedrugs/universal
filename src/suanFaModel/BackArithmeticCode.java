/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package suanFaModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯算法
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484709&idx=1&sn=1c24a5c41a5a255000532e83f38f2ce4&chksm=9bd7fb2daca0723be888b30345e2c5e64649fc31a00b05c27a0843f349e2dd9363338d0dac61&scene=21#wechat_redirect
 *
 * @author xiaokuo
 * @since 2021/3/5 11:39 上午
 */
public class BackArithmeticCode {

    public static void main(String[] args) {
        BackArithmeticCode cl = new BackArithmeticCode();
//        System.out.println(cl.permute(new int[]{1, 2, 3}));
        System.out.println(cl.solveNQueens(4));
    }


    /**
     * 模板
     */
    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;

            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

    /**
     * 51
     * n 皇后问题
     */
    List<List<String>> ret51 = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        String[][] board = new String[n][n];
        for (String[] strings:board){
            Arrays.fill(strings,".");
        }

        helper51(board, 0);
        return ret51;
    }

    void helper51(String[][] board, int row) {

        // 路径：board 中小于 row 的那些行都已经成功放置了皇后
// 选择列表：第 row 行的所有列都是放置皇后的选择
// 结束条件：row 超过 board 的最后一行
        if (row == board.length) {
            List<String> tmp = arr2List(board);
            ret51.add(tmp);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (!valid(row, col, board)) {
                continue;
            }
            board[row][col] = "Q";
            helper51(board, row + 1);
            board[row][col] = ".";
        }

    }

    private List<String> arr2List(String[][] board) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                str.append(board[i][j]);
            }
            temp.add(String.valueOf(str));
        }
        return temp;
    }

    boolean valid(int row, int col, String[][] board) {

        //横
        for (int heng = 0; heng < board.length; heng++){
            if (board[row][heng].equals("Q") || board[heng][col].equals("Q")){
                return false;
            }
        }
        //竖


        //丿
        for(int i = col, j = row; i >= 0 && j >= 0; i--,j--){
            if(board[j][i].equals("Q")){
                return false;
            }
        }

        for(int i = col, j = row; i <  board.length && j < board.length; i++,j++){
            if(board[j][i].equals("Q")){
                return false;
            }
        }

        for(int i = col, j = row; i <  board.length && j >= 0; i++,j--){
            if(board[j][i].equals("Q")){
                return false;
            }
        }


        for(int i = col, j = row; j <  board.length && i >= 0; j++,i--){
            if(board[j][i].equals("Q")){
                return false;
            }
        }

        return true;
    }

}

