package Daily;

public class Leetcode877 {
    public static void main(String[] args) {
        int[] piles = new int[]{5,3,4,5};

        Leetcode877 leetcode877 = new Leetcode877();
        System.out.println(leetcode877.stoneGame(piles));
    }
    /* 记忆化搜索的解法
    int[][] dp;
    boolean[][] isVisited;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        isVisited = new boolean[n][n];
        boolean flag = false; // flag = 0代表Alice取，flag = 1 代表Bob取
        int sum = 0;

        sum = Math.max(piles[0] + stoneSum(piles, flag, 1, n), piles[n - 1] + stoneSum(piles, flag, 0, n - 1));

        return sum > 0;
    }

    public int stoneSum(int[] piles, boolean flag, int start, int end) { // num的取值在0-n-1
        if (isVisited[start][end - 1]) {
            return dp[start][end - 1];
        }
        if (start >= end - 1)
            return piles[start];

        if (flag) { // Alice取
            dp[start][end - 1] = piles[start] + stoneSum(piles, false, start + 1, end);
            dp[start][end - 1] = Math.max(dp[start][end - 1], piles[end - 1] + stoneSum(piles, false, start, end - 1));
        } else {
            dp[start][end - 1] = stoneSum(piles, true, start + 1, end) - piles[start];
            dp[start][end - 1] = Math.min(dp[start][end - 1], stoneSum(piles, true, start, end - 1) - piles[end - 1]);
        }

        isVisited[start][end - 1] = true;
        return dp[start][end - 1];
    }
    */

    // 动态规划解法
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n]; // dp[0][n - 1]表示当从0...n-1中挑石子时，能取得的对当前人最有利的石子数量差
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            dp[i][i] = - piles[i]; // 只剩一个时，Bob取
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                if (flag) {
                    dp[i][i + len] = Math.max(piles[i] + dp[i + 1][i + len], piles[i + len] + dp[i][i + len - 1]);
                } else {
                    dp[i][i + len] = Math.min(dp[i + 1][i + len] - piles[i], dp[i][i + len - 1] - piles[i + len]);
                }
            }
            flag = !flag;
        }
        return dp[0][n - 1] > 0;
    }

}
