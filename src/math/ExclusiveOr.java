package math;

public class ExclusiveOr {
    public static void main(String[] args) {
        int a = 19, b = 21;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 异或运算交换两个数的值
     * 缺点:两个数不能必须指向不同的内存空间 不然会变成0
     */
    public static void swap(int a, int b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
