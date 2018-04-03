
#快速排序
## 1.代码
```
import java.util.Scanner;

/**
 * @author zhangyong@shopin.cn
 * @date 2018/3/13
 * @desc 快速排序
 */
public class QuickSort {

    public static void QuickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left, j = right, key = arr[left];
        while (i < j) {
            while (i < j && key <= arr[j]) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && key > arr[i]) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = key;
        QuickSort(arr, left, i - 1);
        QuickSort(arr, i + 1, right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        QuickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
```
## 2.时间复杂度
```
  O(n*logN)
```
## 3.原理分析
![](http://chuantu.biz/t6/257/1521289825x-1404764810.png)