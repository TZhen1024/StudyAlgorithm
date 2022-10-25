package GraphSearch;

import java.util.ArrayList;

public class Leetcode934 {
    public static void main(String[] args) {

    }

    ArrayList<Integer> island1 = new ArrayList<>();
    ArrayList<Integer> island2 = new ArrayList<>();
    public int shortestBridge(int[][] grid) {
        // 首先找到两座岛的所有点，然后计算最小数目就是横纵坐标差的绝对值之和的最小值
        // 通过直接改gird的值为2来表示已访问
        int n = grid.length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    dfs(grid, i, j, num++);
            }
            if (num == 2)
                break;
        }

        int res = 100000;
        for (int i = 0; i < island1.size(); i++) {
            int x1 = island1.get(i) / n, y1 = island1.get(i) % n;
            for (int j = 0; j < island2.size(); j++) {
                int x2 = island2.get(j) / n, y2 = island2.get(j) % n;
                res = Math.min(res, Math.abs(x2 - x1) + Math.abs(y2 - y1) - 1);
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j, int num) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;

        if (num == 0) island1.add(i * n + j);
        else island2.add(i * n + j);

        dfs(grid, i, j + 1, num);
        dfs(grid, i + 1, j, num);
        dfs(grid, i, j - 1, num);
        dfs(grid, i - 1, j, num);

    }
}
