package TwoPoniters;

public class Leetcode977 {
    public static void main(String[] args) {

    }

    public int[] sortedSquares(int[] nums) {
        // 像这种左右交替的，可以考虑双指针

        int i = 0, j = nums.length - 1;
        int n = nums.length;
        int[] res = new int[n];

        while (i < j) {
            res[--n] = Math.abs(nums[i]) > Math.abs(nums[j]) ? nums[i] * nums[i++] : nums[j] * nums[j--];
        }

        res[n - 1] = nums[i] * nums[i];
        return res;

    }
}
