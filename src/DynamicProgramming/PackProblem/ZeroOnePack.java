package DynamicProgramming.PackProblem;

public class ZeroOnePack {
    public static void main(String[] args) {
        int[] cost = new int[] {1, 2, 3, 4, 5};
        int[] value = new int[] {2, 4, 4, 5, 6};
        int v = 6;
        System.out.println(solve(cost, value, v));
        System.out.println(solve2(cost, value, v));
    }

    /*
        cost[i]: i物品的花费，从0开始
        value[i]: i物品的价值，从0开始
        v: 背包容量

        未优化空间复杂度的解法
     */
    public static int solve(int[] cost, int[] value, int v) {
        /*
            参考背包九讲
            状态F[i,v]表示前i件物品**恰**放入一个容量为v的背包可以获得的最大价值
            状态转移方程：F[i,v] = max{F[i - 1, v], F[i - 1, v - C_i] + V_i}
         */
        int n = cost.length;
        int[][] dp = new int[n + 1][v + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                // 当我们选择一个物品是否加入时，由两个选择，一个是不加入，一个是加入
                // 所以在考虑这个物品的选取会有相应两个假设情况
                // 一个是假设不选，我们应该利用前面的哪个结果
                // 一种是假设选，我们应该利用前面的哪个结果
                if (j >= cost[i - 1]) // 只有当剩余容量大于cost[i - 1]时才可以选
                    // 注意cost[i - 1] 是第i件物品的花费
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i - 1]] + value[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][v];
    }

    /*
        滚动数组优化空间复杂度为O(V)的方法

        不要一开始就去考虑滚动数组的解法，而是在基础方法写出来的情况下去考虑
        或者直接背下来..
     */

    public static int solve2(int[] cost, int[] value, int v) {
        int n = cost.length;
        int[] dp = new int[v + 1];
        for (int i = 1; i < n + 1; i++) {
            // 这里要从大到小递减计算
            // 因为如果是从小到大计算，那么在计算下标较大的dp[j]时，引用的dp[j - cost[i - 1]]可能是第i轮计算出的，而不是第i - 1轮计算出的
            // 在滚动数组的时候，常常是有一个维度是每次只会使用上一轮的数据，要避免访问到本轮计算出的数据
            // 同solve方法比较，就是，每次要使用i-1的结果
            for (int j = v; j >= cost[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i - 1]] + value[i - 1]);
            }
        }
        return dp[v];
    }
}
