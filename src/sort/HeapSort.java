package sort;

import java.util.Arrays;

/**
 * 堆排序
 * 大根堆 交换堆顶元素到最后一个位置
 * 时间复杂度O(NlogN)
 * 额外空间复杂度O(1)
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //上移
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //下移
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//左孩子
        while (left < heapSize) {
            int largest;
            if (left + 1 < heapSize && arr[left + 1] > arr[left]) {
                largest = left + 1;
            } else {
                largest = left;
            }
            if (arr[largest] <= arr[index]) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
