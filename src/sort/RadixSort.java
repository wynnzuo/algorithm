package sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    //跟数据集有关，不能对负数排序
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr, int left, int right, int digit) {
        final int radix = 10;
        int i, j;
        //辅助空间
        int[] bucket = new int[right - left + 1];
        for (int d = 1; d <= digit; d++) {//最大数有多少位 入桶出桶几次
            //count[]  数组为前缀和数组 目的是为了bucket分区
            //count[0] 当前位(d位)是数字0的数字有多少个
            //count[1] 当前位(d位)是数字0,1的数字有多少个
            int[] count = new int[radix];
            for (i = left; i <= right; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] += count[i - 1];
            }
            //从后遍历的目的是为了保持原顺序不变
            for (i = right; i >= left; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = left, j = 0; i <= right; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private static int getDigit(int x, int d) {
        // 192求第2位数  192/10=19 19%10=9
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 4, 3, 2, 1};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
