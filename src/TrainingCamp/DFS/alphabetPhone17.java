/*
 * Copyright (c) 2022. 贝壳找房（北京）科技有限公司
 */
package TrainingCamp.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Description
 *
 * @author xiaokuo
 * @since 2022/4/11 8:45 下午
 */
public class alphabetPhone17 {

  private char[][] phones =  {
    {'a', 'b', 'c', '0'}, {'d', 'e', 'f', '0'},
    {'g', 'h', 'i', '0'}, {'j', 'k', 'l', '0'},
    {'m', 'n', 'o', '0'}, {'p', 'q', 'r', 's'},
    {'t', 'u', 'v', '0'}, {'w', 'x', 'y', 'z'}
  };

  public static void main(String[] args) {
    alphabetPhone17 cl = new alphabetPhone17();
    System.out.println(cl.letterCombinations("23"));
  }

  public List<String> letterCombinations(String digits) {

    int len = digits.length();
    List<String> res = new ArrayList<>();
    if(len < 1){
      return res;
    }

    dfs(digits, 0, res, "");
    return  res;
  }

  private  void dfs(String digits, int start,List<String> res, String path){

    if(path.length() == digits.length()){
      res.add(path);
      return;
    }

    int index = digits.charAt(start) - '0' - 2;
    char[]  alphabet = phones[index];

    for(int i = 0; i < 4; i++){
      path += String.valueOf(alphabet[i]);
      dfs(digits, start + 1, res, path);
      path = path.substring(0, path.length() - 1);
    }
  }

}
