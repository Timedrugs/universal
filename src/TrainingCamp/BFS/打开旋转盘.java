package TrainingCamp.BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaokuo
 * @since 2021/3/31 11:11 下午
 * https://leetcode-cn.com/problems/open-the-lock/
 * 752
 */

public class 打开旋转盘 {

    public static void main(String[] args) {
        打开旋转盘 cl = new 打开旋转盘();
//        System.out.println(cl.up("1234", 1));
    }
    public int openLock(String[] deadends, String target) {
        if(target.length() == 0){
            return -1;
        }
        Set<String> filedStr = new HashSet<>();
        for (String deadend: deadends) {
            filedStr.add(deadend);
        }

        List<String> q = new ArrayList<>();
        List<String> visited = new ArrayList<>();
        int step = 0;
        q.add("0000");
        visited.add("0000");
        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                String cur = q.remove(0);
                if (filedStr.contains(cur)){
                    continue;
                }

                if (target.equals(cur)){
                    return step;
                }

                for (int j = 0; j < 4; j++){
                   String upS =  up(cur, j);
                   if (!visited.contains(upS)){
                       visited.add(upS);
                       q.add(upS);
                   }
                    String downS =  down(cur, j);
                    if (!visited.contains(downS)){
                        visited.add(downS);
                        q.add(downS);
                    }
                }
            }
            step++;
        }
        return  -1;
    }

    private String down(String cur, int j) {
        char[] ch = cur.toCharArray();
        if(ch[j] == '0'){
            ch[j] = '9';
        }else{
            ch[j] -= 1;
        }
        return new String(ch);
    }

    private String up(String s, int index){

        char[] ch = s.toCharArray();
        if(ch[index] == '9'){
            ch[index] = '0';
        }else{
            ch[index] += 1;
        }
        return new String(ch);
    }
}
