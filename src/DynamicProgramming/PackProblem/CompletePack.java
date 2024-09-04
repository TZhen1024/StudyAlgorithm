package DynamicProgramming.PackProblem;

public class CompletePack {

    public static void main(String[] args) {

    }

    /*
        完全背包
        v: 背包容量
     */
    public static int sovle(int[] cost, int[] value, int v) {
        int n = cost.length;
        int[][] dp = new int[n + 1][v + 1];

        /*
            dp[i][j]表示考虑前i件物品，容量为j时的最大价值
            下面分两种情况，一种是完全没有选过第i件物品的，这次也不打算选
            另一种情况是，可能选过第i件物品的，这次打算选（没有选过第i件物品且这次打算选的也包含在这种状态内）
            因为第i轮权衡了是否添加第i件物品，不是一定添加了第i件物品
            在求dp[i][j]时，
         */
        for (int i = 1; i < n + 1; i++) { // 考虑第i - 1件物品
            for (int j = cost[i - 1]; j < v + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - cost[i - 1]] + value[i - 1]);
            }
        }
        return dp[n][v];
    }
}
