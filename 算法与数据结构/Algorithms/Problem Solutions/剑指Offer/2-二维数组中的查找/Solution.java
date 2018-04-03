/**
 * @author littledream1502@gmail.com
 * @date 2018/1/7
 * @desc 二维数组中的查找
 */
public class Solution {
    /**
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        /**
         * 1 2 3 4 5
         * 2 3 4 5 6
         * 3 4 5 6 7
         * 4 5 6 7 8
         */

        /**
         *  矩阵列数;
         */
        int m = array[0].length;
        /**
         * 矩阵行数;
         */
        int n = array.length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (array[i][j] == target) {

                return true;
            } else if (array[i][j] > target) {

                j--;
            } else {

                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
