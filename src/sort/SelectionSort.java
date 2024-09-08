package sort;

import java.util.Arrays;

//选择排序
//时间复杂度O(N²)
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                swap(arr, i, minIndex);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 3, 2, 1};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
