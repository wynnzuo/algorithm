package math;

public class ExclusiveOr {
    public static void main(String[] args) {
        swap();
        findOddNum();
        findOddTwoNum();
    }

    /**
     * 异或运算交换两个数的值
     * 异或运算定义:相同为1 不同为0 或者理解成无进数位相加
     * 异或运算 0^x=x x^x=0
     * 满足交换律 结合律
     * 缺点:两个数不能必须指向不同的内存空间 不然会变成0
     */
    public static void swap() {
        int a = 19, b = 21;
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 一个数组只有一个数字是奇数个数 找出这个数字
     */
    public static void findOddNum() {
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5};
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        System.out.println(result);
    }

    /**
     * 一个数组有两个数字是奇数个数 找出这两个数字
     * 思路:假设两个数字是a b 异或整个数组之后结果为a^b
     * 因为a b是不同的两个数 所以a^b肯定不为0 有位等于1 而这个等于1的位肯定来自于a 或者b
     * 去异或数组上相同位数有1的数字 得到a或b
     * 继续异或a^b 得到b或a
     */
    public static void findOddTwoNum() {
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 5, 6};
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        int rightOne = result & (~result + 1);//提取出最右的1
        int aOrb = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) == 0) {
                aOrb = aOrb ^ arr[i];
            }
        }
        System.out.println(aOrb);
        System.out.println(result ^ aOrb);
    }
}
