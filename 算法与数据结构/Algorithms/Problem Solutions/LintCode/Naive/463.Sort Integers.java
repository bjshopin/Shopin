/**
 * URL:http://www.lintcode.com/en/problem/sort-integers/
 * Question:
 * Given an integer array, sort it in ascending order. Use selection sort, bubble sort, insertion sort or any O(n2) algorithm.
 */
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        int temp=0;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<A.length-i;j++){
                if(A[j]>A[j+1]){
                    temp=A[j+1];
                    A[j+1]=A[j];
                    A[j]=temp;
                }
            }
        }
    }
    //another method -QuickSort
    public void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0) {
			return;
		}
		if (low >= high) {
			return;
		}
		int middle = low + (high - low) / 2;
		int val = arr[middle];

		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < val) {
				i++;
			}
			while (arr[j] > val) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (low < j) {
			quickSort(arr, low, j);
		}
		if (high > i) {
			quickSort(arr, i, high);
		}
	}

}
/**
 * 
 *
 */
