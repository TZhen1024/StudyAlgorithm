package Daily;

import java.util.Arrays;

public class Leetcode1620 {
    public static void main(String[] args) {
        int[][] towers = new int[][]{
                {23, 11, 21}
        };
        int radius = 9;
        Leetcode1620 leetcode1620 = new Leetcode1620();
        System.out.println(Arrays.toString(leetcode1620.bestCoordinate(towers, radius)));
    }
    // 直接暴力了
    public int[] bestCoordinate(int[][] towers, int radius) {
        int rx = 0, ry = 0, intensity = 0; // 返回的坐标、最大信号强度

        for (int i = 0; i < towers.length; i++) { // 遍历tower
            for (int dx = 0; dx <= radius; dx++) {
                for (int dy = 0; dy <= radius && dx * dx + dy * dy <= radius * radius; dy++) {
                    int x = towers[i][0] + dx, y = towers[i][1] + dy;
                    int now = getIntensity(towers, x, y, radius);
                    if (now > intensity) {
                        rx = x;
                        ry = y;
                        intensity = now;
                    } else if (now == intensity) {
                        if (rx < 0 && x >= 0) {
                            rx = x;
                            ry = y;
                        } else if (rx > x || (rx == x && ry > y)) {
                            rx = x;
                            ry = y;
                        }
                    }
                }
            }
        }
        return new int[]{rx, ry};
    }

    public int getIntensity(int[][] towers, int x, int y, int radius) {
        int intensity = 0;
        for (int i = 0; i < towers.length; i++) {
            int dx = x - towers[i][0];
            int dy = y - towers[i][1];
            double d = dx * dx + dy * dy;
            if (d <= radius * radius) {
                d = Math.sqrt(d);
                intensity += Math.floor(towers[i][2] / (1 + d));
            }
        }
        return intensity;
    }
}
