package GraphSearch;

public class Leetcode130 {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'X','X','X','X','X','O'},
                {'O','O','O','O','X','X'},
                {'X','X','O','O','X','O'},
                {'O','O','X','X','X','X'}
        };
        solve(board);
    }
    static int size = 0;
    public static void solve(char[][] board) {
        // 一个比较常规的想法是，我把修改过的位置存起来，之后如果不需要变，我再改回来
        // 上面这个想法不太好，官解是从边界开始广搜标记与边界上的'O'相连的元素，最后遍历整个矩阵
        int m = board.length;
        int n = board[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'O') {
                    size = 0;
                    int[] changed = new int[m * n];
                    changed[size++] = i * n + j;
                    board[i][j] = 'X';
                    dfs(board, changed, i, j);
                }
            }
        }

    }

    public static boolean dfs(char[][] board, int[] changed, int x, int y) {

        int m = board.length;
        int n = board[0].length;

        if (x == m - 1 || x == 0 || y == n - 1 || y == 0) {
            while (size > 0) {
                size--;
                board[changed[size] / n][changed[size] % n] = 'O';
            }
            return false;
        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (board[mx][my] == 'O') {
                changed[size++] = mx * n + my;
                board[mx][my] = 'X';
                if (!dfs(board, changed, mx, my)) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*
O O O
O O O
O O O

{'O','X','X','O','X'},
{'X','O','O','X','O'},
{'X','O','X','O','X'},
{'O','X','O','O','O'},
{'X','X','O','X','O'}

{'O','X','O','O','O','X'},
{'O','O','X','X','X','O'},
{'X','X','X','X','X','O'},
{'O','O','O','O','X','X'},
{'X','X','O','O','X','O'},
{'O','O','X','X','X','X'}
 */