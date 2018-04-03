/**
 * @author littledream1502@gmail.com
 * @date 2018/1/7
 * @desc 数组中只出现一次的数字
 */
public class Solution {

    /**
     * n 过大，会出现堆栈溢出;
     *
     * @param n
     * @return
     */
   /* public int Fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
    }*/
    public int Fibonacci(int n) {
        int f1 = 1, f2 = 1, f3 = 0;
        if (n == 1 || n == 2) return f1;
        else {

            for (int i = 3; i <= n; i++) {
                f3 = f1 + f2;
                f1 = f2;
                f2 = f3;
            }
            return f3;
        }
    }
    public static void main(String[] args) {
        //result 55
        System.out.println(new Solution().Fibonacci(10));
    }
}
