package TrainingCamp.BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiaokuo
 * @since 2021/4/1 12:07 上午
 * 127
 */
public class 单词接龙 {

    public static void main(String[] args) {
        单词接龙 cl = new 单词接龙();
        List<String> wordList = new ArrayList<>();
//        new String[]{"hot","dot","dog","lot","log","cog"}
//        "hit"
//        "cog"
//            ["hot","dot","dog","lot","log","cog"]
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(cl.testMain("hit",  "cog", wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int bLen = beginWord.length();
        int eLen = endWord.length();
        if(bLen != eLen){
            return 0;
        }
        if(endWord.equals(beginWord)){
            return 0;
        }
        int len = wordList.size();
        List<String> q = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        int step = 1;
        q.add(beginWord);
        visited.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.remove(0);

                for(int j = 0; j < len; j++){
                    String word = wordList.get(j);
                    if(visited.contains(word)){
                        continue;
                    }
                    if(canUse(cur, word)){
                        if(word.equals(endWord)){
                            return step;
                        }
                        visited.add(word);
                        q.add(word);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private boolean canUse(String cur, String word){
        int len = cur.length();
        int diff = 0;
        for(int i = 0; i < len; i++){
            if(cur.charAt(i) != word.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }


    public  int testMain(String beginWord, String endWord, List<String> wordList){

        if(endWord.equals(beginWord)){
            return 1;
        }
        int len = wordList.size();
        List<String> q = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        q.add(beginWord);
        visited.add(beginWord);
        int step = 1;
        while (!q.isEmpty()){

            int size = q.size();
            step++;
            for(int i = 0; i < size; i++){
                String cur = q.remove(0);

                for (int j = 0; j < len; j++){
                    String c = wordList.get(j);
                    if (!canUse1(c, cur)){
                        continue;
                    }

                    if(visited.contains(c)){
                        continue;
                    }
                    if (c == endWord){
                        return step;
                    }
                    visited.add(c);
                    q.add(c);
                }
            }
        }

        return 0;
    }

    private boolean canUse1(String c, String beginWord) {

        int len = beginWord.length();
        int diff = 0;
        for(int i = 0; i < len; i++){
            if (c.charAt(i) == beginWord.charAt(i)){
                continue;
            }
            diff++;
        }

        return diff == 1 ? true : false;
    }
}
