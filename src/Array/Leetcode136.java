package Array;

public class Leetcode136 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1};
        System.out.println(new Leetcode136().singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        //  x^x = 0
        // 0 ^ 1 = 1
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
