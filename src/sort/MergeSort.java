package sort;

import java.util.Arrays;

public class MergeSort {
    /**
     * 归并排序 O(NlogN)
     * 左边排好序 右边排好序 整体有序
     * 整体有序使用了外排序 额外空间复杂度O(N)
     * 递归计算时间复杂度 master公式
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        process(arr, 0, arr.length - 1);
    }

    protected static void process(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    protected static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
