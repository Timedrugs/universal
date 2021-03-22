/*
 * Copyright (c) 2021. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.递归;

import javax.print.DocFlavor.READER;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2021/3/22 1:45 下午
 */
public class 模板 {

    private int maxLevel = Integer.MAX_VALUE;
    public void recur(int level, int param){
        //terminator
        if (level > maxLevel){

            //process result
            return;
        }

        //process current logic
        process(level, param);

        //dill down
        int newParam = 0;//转换下
        recur(level + 1, newParam);

        //restore current status
    }

    private void process(int level, int param){

    }

}
