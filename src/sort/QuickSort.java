package sort;

import java.util.Arrays;

/**
 * 快速排序算法
 * 随机选数 时间复杂度O(NlogN)
 * 不然 时间复杂度O(N²)
 * 空间复杂度O(logN)
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);//随机选一个数
            int[] p = partition(arr, left, right);
            quickSort(arr, left, p[0]);
            quickSort(arr, p[1], right);
        }

    }

    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;//区左边界
        int more = right;//区右边界
        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more++, right);
        return new int[]{less, more};

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
