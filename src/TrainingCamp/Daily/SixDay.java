package TrainingCamp.Daily;

import java.util.HashMap;

/**
 * @author xiaokuo
 * @since 2021/3/13 7:36 下午
 */
public class SixDay {

    public static void main(String[] args) {
        SixDay cl = new SixDay();
        System.out.println(cl.getHint("7081", "7810"));
    }

    /**
     *299. 猜数字游戏
     */
    public String getHint(String secret, String guess) {

        int len = secret.length();
        int[] arr = new int[10];
        int a = 0;
        int b = 0;
        for(int i = 0; i < len; i++){

            if (secret.charAt(i) == guess.charAt(i)){
                a++;
            }else {
                // 判断 guess 在 i 之前是否该数字
                if (arr[secret.charAt(i) - '0']++ < 0) {
                    b++;
                }
                // 判断 secret 在 i 之前是否该数字
                if (arr[guess.charAt(i) - '0']-- > 0) {
                    b++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(a).append('A').append(b).append('B').toString();

    }
}
