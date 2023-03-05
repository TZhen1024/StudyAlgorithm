package Array;

public class Leetcode59 {
    public static void main(String[] args) {
        Leetcode59 leetcode59 = new Leetcode59();
        System.out.println(leetcode59.generateMatrix(3));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int bound = n;
        int x = 0, y = 0; // 每轮循环的起始点
        int num = 1;
        while (bound > 0) {
            for (int i = 0; i < bound; i++) { // 横着正向 固定x
                res[x][y + i] = num++;
            }
            for (int i = 1; i < bound; i++) { // 竖着正向 固定 y + bound - 1
                res[x + i][y + bound - 1] = num++;
            }
            for (int i = 1; i < bound; i++) { // 横着逆向 固定 x + bound - 1
                res[x + bound - 1][y + bound - 1 - i] = num++;
            }
            for (int i = 1; i < bound - 1; i++) { // 竖着逆向 固定 y
                res[x + bound - 1 - i][y] = num++;
            }
            x++;
            y++;
            bound -= 2;
        }

        return res;
    }
}
