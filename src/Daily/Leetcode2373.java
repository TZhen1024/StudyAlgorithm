package Daily;

public class Leetcode2373 {
    public static void main(String[] args) {

    }

    public int[][] largestLocal(int[][] grid) {
        // 直接暴力了
        // 看题解这道题有更好的解法，二维单调队列
        int n = grid.length;
        int[] dx = new int[] {-1, 0, 1};
        int[] dy = new int[] {-1, 0, 1};
        int[][] res = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                res[i - 1][j - 1] = grid[i][j];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        res[i - 1][j - 1] = Math.max(res[i - 1][j - 1], grid[i + dx[k]][j + dy[l]]);
                    }
                }
            }
        }
        return res;
    }
}
