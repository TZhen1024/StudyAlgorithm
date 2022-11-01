package DynamicProgramming;
/*
    本题为最长回文字串，我也不太清楚自己的做法属不属于动态规划
    从目前的想法来看，动态规划跟记忆化的搜索或者递归有很多相似之处，我有点分不清了。但一说动态规划通常是迭代的而不是递归的
    另外本题还有中心扩散法和Manacher算法（马拉车算法）
    中心扩散法就是针对每一个位置找从这个位置能扩展的最长回文字串
    Manacher算法算是优化的中心扩散法
 */
public class Leetcode5 {
    public static void main(String[] args) {
        String s = "acacabcbac";
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.longestPalindrome(s));
    }

    int[][] m; // 1表示已访问，且是回文；2表示以访问，不是回文
    public String longestPalindrome(String s) {
        int n = s.length();
        m = new int[n][n]; // 1表示已访问且是回文
        for (int i = 0; i < n; i++) {
            m[i][i] = 1;
        }
        int len = n;
        for (len = n; len > 1; len--) {
            for (int i = 0; i + len - 1 < n; i++) {
                if (isPalindrome(s, i, i + len - 1))
                    return s.substring(i, i + len);
            }
        }
        return s.substring(0, 1);
    }

    public boolean isPalindrome(String s, int i, int j) {
        /* 直接循环判断是否回文
            int i = 0, j = s.length() - 1;
            while (j >= i) {
                if (s.charAt(i++) != s.charAt(j--)) {
                    return false;
                }
            }
            return true;
        */
        /*  isPalindrome(String s)
            if (s.length() == 1 || (s.length() == 2 && s.charAt(0) == s.charAt(1))) {
                return true;
            }
            if (s.charAt(0) == s.charAt(s.length() - 1)) {
                return isPalindrome(s.substring(1, s.length() - 2));
            } else {
                return false;
            }
        */
        if (m[i][j] == 2)
            return false;
        else if (m[i][j] == 1)
            return true;

        if (s.charAt(i) == s.charAt(j)) {
            if (i == j - 1) {
                m[i][j] = 1;
                return true;
            } else if (isPalindrome(s, i + 1, j - 1)) {
                m[i][j] = 1;
                return true;
            }
        }
        m[i][j] = 2;
        return false;
    }
}
