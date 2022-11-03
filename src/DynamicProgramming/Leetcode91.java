package DynamicProgramming;

public class Leetcode91 {
    public static void main(String[] args) {
        String s = "10";
        Leetcode91 leetcode91 = new Leetcode91();
        System.out.println(leetcode91.numDecodings(s));
    }

    // 应该可以通过回溯做，但是回溯需要把所有串都生成一下
    // 考虑利用之前的结果进行计算
    // 设dp[i]是从下标i到下标n-1的字串的解码方法的总数

    public int numDecodings(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int[] dp = new int[n + 1];
        if (n == 1) {
            return charArray[0] == '0' ? 0 : 1;
        }

        dp[n] = 1; // 在i = n - 2计算dp[i + 2]时使用
        dp[n - 1] = charArray[n - 1] == '0' ? 0 : 1;
        if (charArray[n - 1] == '0' && !(charArray[n - 2] == '1' || charArray[n - 2] == '2')) {
            return 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (charArray[i] >= '3') { // 题中条件s中只包含数字
                dp[i] = dp[i + 1];
            } else if (charArray[i] == '1') { // 单独解码’1’或者与其后一位一同解码
                dp[i] = dp[i + 1] + dp[i + 2]; // 单独解码‘1’有dp[i+1]种方法，与其后一位一同解码则多dp[i+2]中解法
            } else if (charArray[i] == '2') { // '2'
                dp[i] = charArray[i + 1] <= '6' ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            } else { // '0'
                if (i == 0 || !(charArray[i - 1] == '1' || charArray[i - 1] == '2')) {
                    return 0;
                }
            }
        }
        return dp[0];
    }
}
