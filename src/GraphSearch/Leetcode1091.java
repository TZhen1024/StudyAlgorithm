package GraphSearch;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode1091 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        // 来个广度优先搜索

        if (grid[0][0] == 1 || grid[n - 1][n-1] == 1)
            return -1;

        // 行的变化 这里必须是8个方向，不能减为右下角的5个，可以看测试用例1
        int dx[] = new int[]{1, 0, -1, -1, -1, 0, 1, 1};
        // 列的变化
        int dy[] = new int[]{1, 1, 1, 0, -1, -1, -1, 0};

       /*
        int[][] len = new int[n][n];
        len[0][0] = 1;

        *//* 这里的Que可以不是存数组对象，如下面非注释部分
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{0, 0});
        *//*
        int ans = 1;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.offer(0);

        while (!que.isEmpty()) {
            int x = que.peek() / n;
            int y = que.poll() % n;

            for (int i = 0; i < 8; i++) {
                int mx = x + dx[i], my = y + dy[i];
                // 这里，如果len[mx][my]不为0，说明这个地方已经被访问过，而且此时的长度，已经是最小长度
                // 而且基于上述特征，可以知道，进行层序遍历，每一层遍历长度加1，可以把len优化掉, 见解法2
                if (mx < n && mx >= 0 && my < n && my >= 0 && grid[mx][my] == 0 && len[mx][my] == 0) {
                    que.offer(n * mx + my);
                    len[mx][my] = len[x][y] + 1;
                }
            }
        }

        return len[n - 1][n - 1] == 0 ? -1 : len[n - 1][n - 1];*/

        // 这种实现需要对n = 1的情况进行特判
        if (n == 1)
            return 1;

        int ans = 1;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.offer(0);

        while (!que.isEmpty()) {
            int size = que.size(); // 层序遍历，需要知道当前层的元素个数
            while (size > 0) {
                int x = que.peek() / n;
                int y = que.poll() % n;

                for (int i = 0; i < 8; i++) {
                    int mx = x + dx[i], my = y + dy[i];
                    if (mx < n && mx >= 0 && my < n && my >= 0 && grid[mx][my] == 0) {
                        que.offer(n * mx + my);
                        if (mx == n - 1 && my == n - 1)
                            return ++ans;
                        grid[mx][my] = 1;
                    }
                }
                size--;
            }
            ans++;
        }
        return -1;
    }
}

/*
测试用例1：
[0,1,1,0,0,0],
[0,1,0,1,1,0],
[0,1,1,0,1,0],
[0,0,0,1,1,0],
[1,1,1,1,1,0],
[1,1,1,1,1,0]
 */