import java.util.ArrayList;

/**
 * @author littledream1502@gmail.com
 * @date 2018/1/7
 * @desc 数组中只出现一次的数字
 */
public class Solution {

    /**
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            } else {
                list.remove(new Integer(array[i]));
            }
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}
