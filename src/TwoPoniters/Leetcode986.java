package TwoPoniters;

import util.MyIntArray;

import java.util.ArrayList;

public class Leetcode986 {
    public static void main(String[] args) {
        int[][] firstList1 = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList1 = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        int[][] firstList2 = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList2 = new int[][]{};
        int[][] firstList3 = new int[][]{};
        int[][] secondList3 = new int[][]{{1,5},{8,12},{15,24},{25,26}};
        MyIntArray.output(intervalIntersection(firstList1, secondList1));
        MyIntArray.output(intervalIntersection(firstList2, secondList2));
        MyIntArray.output(intervalIntersection(firstList3, secondList3));



    }

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int first = 0, second = 0; // 分别表示是两个列表的哪个区间，从0起算

        ArrayList<int[]> arr = new ArrayList<>();
        while (first < firstList.length && second < secondList.length) {
            int startI = firstList[first][0], endI = firstList[first][1];
            int startJ = secondList[second][0], endJ = secondList[second][1];

            /* 可以简化
            if (endI < startJ) { // 这里跟下面的endI < endJ可以合并
                first++;
            } else if (endJ < startI) {
                second++;
            } else {
                int[] now = new int[]{Math.max(startI, startJ), Math.min(endI, endJ)};
                arr.add(now);
                if (endI < endJ)
                    first++;
                else
                    second++;
            }*/

            int lo = Math.max(startI, startJ);
            int hi = Math.min(endI, endJ);
            if (lo <= hi) {
                int[] now = new int[]{lo, hi};
                arr.add(now);
            }
            if (endI < endJ)
                first++;
            else
                second++;
        }

        return arr.toArray(new int[arr.size()][]);
    }
}
