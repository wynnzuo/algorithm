package sort;

import java.util.Arrays;

public class InsertionSort {
    /**
     * 插入排序算法 O(N²)
     * 跟数据集合有关 最好的时间复杂度是N
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
