package BackTrack;

public class Leetcode79 {
    public static void main(String[] args) {

    }

    boolean[][] isVisited;
    public boolean exist(char[][] board, String word) {
        // isVisited 先设为true，之后再设回false

        int m = board.length;
        int n = board[0].length;
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx) || isVisited[i][j]) {
            return false;
        }

        if (idx == word.length() - 1)
            return true;

        isVisited[i][j] = true;
        boolean res = false;
        res = res || dfs(board, word, i, j + 1, idx + 1);
        res = res || dfs(board, word, i + 1, j, idx + 1);
        res = res || dfs(board, word, i, j - 1, idx + 1);
        res = res || dfs(board, word, i - 1, j, idx + 1);

        isVisited[i][j] = false;

        return res;
    }
}
