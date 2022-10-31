package DynamicProgramming;

public class Leetcode62 {
    public static void main(String[] args) {
        int m = 2, n = 1;
        Leetcode62 leetcode62 = new Leetcode62();
        System.out.println(leetcode62.uniquePaths(m, n));
    }
    /*
        这里写的动态规划的解法
        但看题解这题果然是数学题
        直接计算组合数C_{m + n - 2}^{m - 1}
     */
    public int uniquePaths(int m, int n) {
        // pathNum[i][j]记录从i，j到终点的路径数
        int[][] pathNum = new int[m][n];

        pathNum[m - 1][n - 1] = 1; // Leetcode上对m = n = 1的情况，结果为1.
        for (int i = 0; i < n - 1; i++) {
            pathNum[m - 1][i] = 1;
        }
        for (int i = 0; i < m - 1; i++) {
            pathNum[i][n - 1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                pathNum[i][j] = pathNum[i + 1][j] + pathNum[i][j + 1];
            }
        }
        return pathNum[0][0];
    }
}
