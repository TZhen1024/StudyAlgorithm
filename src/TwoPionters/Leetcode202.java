package TwoPionters;

import java.util.HashSet;

public class Leetcode202 {
    public static void main(String[] args) {

    }

    // 有一种快慢指针的做法，但我这里没这样做，想不出来..
    // 不过，如果遇到无限循环（注意不是无限不循环）的题目，可以想想快慢指针
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1)
            return true;
        else if (set.contains(n))
            return false;
        set.add(n);
        int m = 0;
        while (n != 0) {
            m += (n % 10) * (n % 10);
            n /= 10;
        }
        return isHappy(m);
    }
}
