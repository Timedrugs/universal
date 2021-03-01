package suanFaModel.RecursiveAndDivide;

/**
 * @author xiaokuo
 * @since 2021/2/28 1:20 下午
 */
public class RecursiveAndDivideCode {

    public static void main(String[] args) {
        RecursiveAndDivideCode cl = new RecursiveAndDivideCode();
//        System.out.println(cl.myPow(2, -1));
        System.out.println(cl.myPow(2.0, 3));
    }

    /**
     * 50
     * n 次方
     */
    public int myPow(int x, int n) {
        if (x == 0 || n == 1){
            return x;
        }
        if (n == 0){
            return 1;
        }

        if (n < 0){
            x = 1/x;
            n = -n;
        }

        int pow = 1;
        //位运算
        while (n >= 1){

            //奇数 * 自己
            if ((n & 1) == 1){
                pow *= x;
            }

            x *= x;
            //右移一位
            n >>= 1;
        }
        return pow;
    }

    public double myPow(double x, int n) {

        if (n == 1){
            return x;
        }

        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);

        } else {

            return x * myPow(x, n - 1);

        }
    }

    /**
     * 169
     * 众数
     * @param nums
     * @return
     * 我们做这样的想象，现在有来自不同阵营的多支部队，他们互为敌人。每个士兵都容不得敌人，宁愿与敌人同归于尽。
     * //    可以想象，如果某个阵营的士兵数量超过所有阵营士兵总数的一半，该阵营士兵一换一带走一个其他阵营的，最终剩下的就是该阵营的士兵了，该阵营就获胜了。
     * //
     * //    这和本题有什么关系呢？且看下面的故事：
     * //
     * //    现在要打仗了，所有士兵依次进入战场，如果战场上有其他阵营的士兵，他就与其中一个同归于尽。否则，他就留在战场上。容易想象，战场上要么没有人，要么是同一阵营的。
     * //    所有士兵都进入战场后，最终战场上剩下的只会是同一阵营的，而该阵营就是人数过半的那个。
     * //
     * //    我们要模拟这个过程，找到那个获胜的阵营。数组中每个元素就是士兵，元素的值，就是这个士兵所属阵营。
     */
    public int majorityElement(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        int len = nums.length;

        int zs = 0 ;
        int count = 0;
        for(int i = 0 ; i< len ; i++){
            if (count == 0){
                count++;
                zs = nums[i];
            }else{
                if (zs == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }

        int k = 0;
        for (int j: nums) {

            if (j == zs){
                k++;
            }

            if (k > len / 2){
                return  zs;
            }
        }

        return  0;
    }
}
