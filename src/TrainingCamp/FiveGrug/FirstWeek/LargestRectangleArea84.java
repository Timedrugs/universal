package TrainingCamp.FiveGrug.FirstWeek;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xiaokuo
 * @since 2021/3/15 10:15 下午
 */
public class LargestRectangleArea84 {

    public static void main(String[] args) {
        LargestRectangleArea84 cl = new LargestRectangleArea84();
        System.out.println(cl.largestRectangleArea(new int[]{2,4}));
        System.out.println(cl.t(new int[]{2,1,5,6,2,3}));
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 1; i < n; i++) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
    public int t(int[] heights){
        int len = heights.length;
        if(len == 0){
            return 0;
        }

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int[] right = new int[len];
        int[] left = new int[len];
        Arrays.fill(right, len);

        for(int i = 1; i < len; i++){

            //栈顶元素太小了 pop
            while(!stack.isEmpty() &&  heights[stack.peek()] >= heights[i]){
                right[stack.peek()] = i;
                stack.pop();
            }

            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        for(int i = 1; i < len; i++){
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }

}
