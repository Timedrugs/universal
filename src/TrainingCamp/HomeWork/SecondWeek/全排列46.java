package TrainingCamp.HomeWork.SecondWeek;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaokuo
 * @since 2021/3/21
 */
public class 全排列46 {


    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0){
            return  res;
        }

        int[] visited = new int[len];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
