import java.util.*;
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countKConstraintSubstrings("01010", 1));
    }
    public int countKConstraintSubstrings(String s, int k) {
        // 注意是满足任一条件
        // 直接暴力
        int n = s.length();

        int res = 0;
        for (int len = 1; len <= n; len++) {
            int numOfOne = 0;
            int numOfZero = 0;
            int l = 0;
            int r = l + len - 1;
            for (int i = l; i <= r; i++) {
                if (s.charAt(i) == '1') numOfOne++;
                else numOfZero++;
            }
            if (numOfOne <= k && numOfZero <= k) res++;
            while (r != n) {
                if (s.charAt(l) == '1') --numOfOne;
                else --numOfZero;
                l++;
                r++;
                if (r == n)
                    break;
                if (s.charAt(l) == '1') ++numOfOne;
                else ++numOfZero;
                if (numOfOne <= k && numOfZero <= k) res++;
            }
        }
        return res;
    }
}
