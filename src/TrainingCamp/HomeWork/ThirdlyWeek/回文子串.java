package TrainingCamp.HomeWork.ThirdlyWeek;

/**
 * @author xiaokuo
 * @since 2021/3/28
 * 647
 * https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class 回文子串 {

    public int countSubstrings(String s) {
//        状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
//        状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false

//        当只有一个字符时，比如 a 自然是一个回文串。
//        当有两个字符时，如果是相等的，比如 aa，也是一个回文串。
//        当有三个及以上字符时，比如 ababa 这个字符记作串 1，把两边的 a 去掉，
//        也就是 bab 记作串 2，可以看出只要串2是一个回文串，那么左右各多了一个 a 的串 1 必定也是回文串。
//        所以当 s[i]==s[j] 时，自然要看 dp[i+1][j-1] 是不是一个回文串。

        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }

        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        int res = 0;
        for (int i = 0; i < n ; i++){
            for (int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j)
                && (i - j < 2 || dp[i - 1][j + 1] == true )){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
