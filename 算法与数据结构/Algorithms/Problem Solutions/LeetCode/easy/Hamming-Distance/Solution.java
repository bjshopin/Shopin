import java.util.Scanner;
/**
 * @author zhangyong@shopin.cn
 * @date 2017/11/7
 * @desc 461. Hamming Distance
 * @url https://leetcode.com/problems/hamming-distance/description/
 */
public class Solution {
    /**
     * Input: x = 1, y = 4
     * Output: 2
     * Explanation:
     * 1  (0 0 0 1)
     * 4  (0 1 0 0)
     * -----------
     * 给你2个数,判断下这两个数的二进制中有多少位是不同的;
     */
    public int hammingDistance(int x, int y) {
        int result = 0;
        int k = x ^ y;
        while (k != 0) {
            if (k % 2 != 0) {
                result += 1;
            }
            k >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(new Solution().hammingDistance(a, b));
    }
}
