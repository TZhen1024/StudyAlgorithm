package Hash;

import java.util.HashSet;

public class Leetcode202 {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        /*
            n最大是2147483647， 10位数
            经过一次运算，最大是9*9*10 = 810
            经过两次运算，最大是8*8 + 9*9 + 9*9 = 226
            经过三次运算，最大是4 + 9*9 + 9*9 = 166
            也就是说，如果是无限循环，那么在166次运算之后，下一个数字肯定是落在之前已经计算过的数字中，由此判断不可能变为1
         */
        HashSet<Integer> set = new HashSet<>();

        set.add(n);

        while (n != 1) {
            n = compute(n);
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }


        return true;
    }

    public int compute(int n) {
        int temp = 0;
        while (n != 0) {
            temp += (n % 10) * (n % 10);
            n = n / 10;
        }
        return temp;
    }
}
