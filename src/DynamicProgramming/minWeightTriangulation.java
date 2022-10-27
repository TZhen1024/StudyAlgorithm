package DynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class minWeightTriangulation {
    public static void main(String[] args) {
        int[][] D = new int[][]{
                {0, 14, 25, 27, 10, 11, 24, 16},
                {0, 0,  18, 15, 27, 28, 16, 14},
                {0, 0,  0,  19, 14, 19, 16, 10},
                {0, 0,  0,  0,  22, 23, 15, 14},
                {0, 0,  0,  0,  0,  14, 13, 20},
                {0, 0,  0,  0,  0,  0,  15, 18},
                {0, 0,  0,  0,  0,  0,  0,  27},
                {0, 0,  0,  0,  0,  0,  0,  0},
        };
        minWeightTriangulation problem = new minWeightTriangulation();
        System.out.println(problem.solve(D));
    }

    /**
     *
     * @param D 输入二维数组D，给出凸多边形P边和弦的权重
     * @return  返回凸多边形P的弦的集合T，T中所有的弦恰好将P分割成互不重叠的三角形，且各三角形的权重之和最小
     */
    public List<List<Integer>> solve(int[][] D) {
        int n = D.length;
        /*
           m[i][j]是以{v_{i+1}, v_{i+2}...v_{j+1}}为顶点的凸多边形进行三角形划分的最小权重
           例如m[0][7]表示凸八边形{v1, v2, ..., v8}进行三角形划分的最小权重
           则m[i][j] = min{ m[i][k] + m[k][j] + D[i][k] + D[k][j] + D[i][j] }, i < k < j
           当j = i + 1时，凸多边形退化成一条边，m[i][j] = 0
         */
        int[][] m = new int[n][n];
        // v[i][j]表示当m[i][j]取到最小值时，选择的k的值，表示选择进行划分的三角形的第三个顶点v_{k+1}
        int[][] v = new int[n][n];

        for (int i = n - 1; i >= 0; i--) { // 由于m[i][j]的求解要用到m[k][j]， k > i, 所以倒序遍历
            // j = i时 m[i][j]不存在，j = i + 1时，m[i][j]已初始化为0；由于m[i][j]求解用到m[i][k], k < j，所以正序遍历
            for (int j = i + 2; j < n; j++) {
                // 首先取k = i + 1， 给m[i][j]一个初始值，方便之后进行比较
                int k = i + 1;
                m[i][j] = m[i][k] + m[k][j] + D[i][k] + D[k][j] + D[i][j];
                v[i][j] = k;
                for (k = i + 2; k < j; k++) {
                    int temp = m[i][k] + m[k][j] + D[i][k] + D[k][j] + D[i][j];
                    if (temp < m[i][j]) { // 当m[i][j]有更小的取值时，更新m[i][j]和v[i][j]
                        m[i][j] = temp;
                        v[i][j] = k;
                    }
                }
            }
        }
        return getT(v, 0, n - 1);
    }

    /**
     * 在solve函数求解的基础上，递归求得弦的集合。
     * @param v solve函数求解出的权重最小的划分所选择的中间顶点
     * @param i 凸多边形的起始顶点（顺时针）
     * @param j 凸多边形的终止顶点
     * @return 返回凸多边形P的弦的集合T，T中所有的弦恰好将P分割成互不重叠的三角形，且各三角形的权重之和最小
     */
    public List<List<Integer>>getT(int[][] v, int i, int j) {
        List<List<Integer>> res = new LinkedList<>(); // 弦的集合T
        List<Integer> t1 = new ArrayList<>(); // 其中的一条弦
        List<Integer> t2 = new ArrayList<>();
        if (v[i][j] > i + 1) { // 当v[i][j] > i + 1时，存在一条弦（否则是一条边）
            res.addAll(getT(v, i, v[i][j])); // 将划分出的凸多边形{v_{i+1},...,V_{k+1}}（k=v[i][j]）的弦加入T
            t1.add(i + 1);
            t1.add(v[i][j] + 1);
            res.add(t1);
        }
        if (v[i][j] < j - 1) {
            t2.add(v[i][j] + 1);
            t2.add(j + 1);
            res.add(t2);
            res.addAll(getT(v, v[i][j], j));
        }
        return res;
    }
}
