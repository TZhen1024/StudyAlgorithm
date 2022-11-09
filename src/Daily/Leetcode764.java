package Daily;

public class Leetcode764 {
    public static void main(String[] args) {
        int n = 5;
        int[][] mines = new int[][] {
                {4, 2}
        };
        Leetcode764 leetcode764 = new Leetcode764();
        System.out.println(leetcode764.orderOfLargestPlusSign(n, mines));
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // 输入不是一个数组，这里采用暴力的方法所以我要把这个nxn数组初始一下
        int[][] nums = new int[n][n];
        for (int i = 0; i < mines.length; i++) { // 注意这里跟题中的1和0相反
            nums[mines[i][0]][mines[i][1]] = 1;
        }
        int l = (n - 1) / 2, r = n / 2; // 如果n是奇数，那么l == r; 如果n是偶数，那么l == r + 1
        int res = 0;
        while (l >= 0) {
            for (int i = l; i <= r; i++) {
                res = getLength(nums, i, l, res);
                res = getLength(nums, i, r, res);
            }
            for (int j = l + 1; j <= r - 1; j++) {
                res = getLength(nums, l, j, res);
                res = getLength(nums, r, j, res);
            }
            l--;
            r++;
        }
        return res;
    }

    public int getLength(int[][] nums, int i, int j, int res) {
        int max = Math.min(Math.min(i + 1, j + 1), Math.min(nums.length - i, nums.length - j));
        if (max <= res)
            return res;
        int now = 0;
        while (now < max && nums[i - now][j] == 0 && nums[i + now][j] == 0 && nums[i][j - now] == 0 && nums[i][j + now] == 0) {
            now++;
        }
        return Math.max(now, res);
    }
}
