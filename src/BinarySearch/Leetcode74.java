package BinarySearch;

public class Leetcode74 {
    public static void main(String[] args) {
        /*int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };*/
        int[][] matrix = {
                {1}
        };
        System.out.println(searchMatrix(matrix, 0));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int ri = 0, rj = matrix.length - 1;
        int li = 0, lj = matrix[0].length - 1;
        int rmid = 0, lmid = 0;
        int r = 0;
        while (ri <= rj) {
            rmid = (ri + rj) / 2;
            if (target < matrix[rmid][0]) {
                rj = rmid - 1;
            } else if (target > matrix[rmid][lj]) {
                ri = rmid + 1;
            } else {
                r = rmid;
                break;
            }
        }
        while (li <= lj) {
            lmid = (li + lj) / 2;
            if (target < matrix[r][lmid]) {
                lj = lmid - 1;
            } else if (target > matrix[r][lmid]) {
                li = lmid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
