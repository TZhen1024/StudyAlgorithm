package GraphSearch;

public class Leetcode200 {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        // 直接把grid改成'2'可以省掉isVisited的空间
        boolean isVisited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    dfs(grid, isVisited, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    public static void dfs(char[][] grid, boolean[][] isVisited, int x, int y) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int m = grid.length;
        int n = grid[0].length;
        isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if (mx < m && mx >= 0 && my < n && my >= 0 && !isVisited[mx][my] && grid[mx][my] == '1') {
                dfs(grid, isVisited, mx, my);
            }
        }
    }
}
