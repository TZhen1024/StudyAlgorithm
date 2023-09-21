package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Leetcode56 {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {{4,5}, {1, 4}, {1, 5}};
        Leetcode56 leetcode56 = new Leetcode56();
        leetcode56.merge(intervals);
    }


    public int[][] merge(int[][] intervals) {
        // 首先对intervals数组进行排序, 第一位从小到大，第二位从大到小
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        

        ArrayList<int[]> res = new ArrayList<>();
        
        int n = intervals.length;

        int i = 0; 
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while (i + 1 < n && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }

            res.add(new int[]{start, end});
            i++;
        }       
        return res.toArray(new int[res.size()][]);

    }
}

