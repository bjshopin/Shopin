/**
 * @author littledream1502@gmail.com
 * @date 2017/12/20
 * @desc 冒泡排序
 */
public class BubbleSort {

    public static int[] BubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    } 
}
