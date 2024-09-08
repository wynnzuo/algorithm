package math;

/**
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。
 * 思路:
 * 1.穷举法 遍历所有左边比当前数小的数加起来 时间复杂度 O(N²)
 * 2.计算有几个右边数比当前节点的数大 计算几个当前节点数的和 利用归并排序计算
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return process(arr, 0, arr.length - 1);
    }

    protected static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) +
                process(arr, mid + 1, right) +
                merge(arr, left, mid, right);
    }

    protected static int merge(int[] arr, int left, int mid, int right) {
        int result = 0;
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                result += (right - j + 1) * arr[i];
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
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 4, 7, 9, 5};
        //6*2+2*4+4*3+7*1=39
        System.out.println(smallSum(arr));
    }
}
