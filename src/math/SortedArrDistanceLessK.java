package math;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 几乎有序数组，排序时元素移动距离小于k（堆排序）
 * 思路 小根堆 堆排序算法
 * 时间复杂度O(KlogN)
 */
public class SortedArrDistanceLessK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 3, 6, 5};
        int k = 3;
        sortedArrDistanceLessK(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortedArrDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = 0;
        for (; i < Math.min(arr.length, k); i++) {
            heap.add(arr[i]);
        }
        int index = 0;
        for (; i < arr.length; i++) {
            heap.add(arr[i]);
            arr[index++] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[index++] = heap.poll();
        }
    }
}
