package TrainingCamp.HomeWork.FourthWeek;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaokuo
 * @since 2021/4/4 11:28 下午
 */
public class 最小基因变化433 {

    /**
     * 典型bfs
     * 类似单词接龙
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)){
            return 0;
        }

        List<String> visited = new LinkedList<>();
        List<String> q = new LinkedList<>();
        int step = 0;
        q.add(start);
        visited.add(start);
        int bL = bank.length;
        while (!q.isEmpty()){

            int size = q.size();
            step++;
            for (int i = 0; i < size; i++){
                String cur = q.remove(0);
                for (int j = 0; j < bL; j++){
                    String curJ = bank[j];
                    if(visited.contains(curJ)){
                        continue;
                    }

                    if(!canUse(cur, curJ)){
                        continue;
                    }
                    if(curJ.equals(end)){
                        return step;
                    }
                    visited.add(curJ);
                    q.add(curJ);
                }
            }
        }

        return -1;
    }

    private boolean canUse(String start, String curJ) {
        int len = start.length();
        int df = 0;
        for (int i = 0; i < len; i++){
            if(start.charAt(i) == curJ.charAt(i)){
                continue;
            }
            df++;
        }
        return df == 1;
    }
}
