```
 给定一个数组int[] arr=new int[]{
     1,2,3,4,5,6,7
 }
 在不使用额外的数组空间的条件下,将数组顺序调整为6,7,1,2,3,4,5
 code:
 
 public class Solution {
    public static void reserveArray(int[] arr, int left, int right) {
        int temp;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        // 1 2 3 4 5 | 6 7
        //step: 1 2 3 4 5 翻转-> 5 4 3 2 1
        //step: 6 7 翻转 -> 7 6
        //数组转变为: 5 4 3 2 1 7 6
        //整体翻转:   6 7 1 2 3 4 5
        // 6 7 | 1 2 3 4 5
        int[] arr = {
                1, 2, 3, 4, 5, 6, 7
        };
        reserveArray(arr, 0, 4);
        reserveArray(arr, 5, 6);
        reserveArray(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

```