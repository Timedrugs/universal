package TrainingCamp.Daily;

/**
 * @author xiaokuo
 * @since 2021/3/24 12:29 上午
 */
public class 替换空格剑指offer05 {
    public String replaceSpace(String s) {
        int len = s.length();
        if(len == 0){
            return s;
        }

        // return s.replace(" ", "%20");

        //或者单独循环，查找替换
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == (' ')){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
