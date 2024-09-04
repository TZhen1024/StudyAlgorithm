package DynamicProgramming;

public class Leetcode279 {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(new Leetcode279().numSquares(n));
    }

    public int numSquares(int n) {
        // 完全背包问题且恰好装满
        int num = (int)Math.sqrt(n); // 物品数量  n =13, num = 4, 考虑1，2，3
        int[] weight = new int[num]; // 物品重量
        // 背包容量为n
        int[][] dp = new int[num + 1][n + 1]; // 表示考虑平方根为前i个数，恰好和为j时所需最少数量
        int max_n = 100000;
        for (int i = 0; i < num; i++) {
            weight[i] = (i + 1) * (i + 1);
        }

        for (int i = 0; i < num + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = max_n;
            }
        }

        for (int i = 1; i < num + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j >= weight[i - 1])
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - weight[i - 1]] + 1);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[num][n];
    }
}
