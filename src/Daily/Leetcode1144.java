package Daily;

public class Leetcode1144 {
    public static void main(String[] args) {
        int[] nums = new int[] {9, 6, 1, 6, 2};
        Leetcode1144 leetcode1144= new Leetcode1144();
        System.out.println(leetcode1144.movesToMakeZigzag(nums));
    }

    public int movesToMakeZigzag(int[] nums) {
        int num1 = 0, num2 = 0;
        int n = nums.length;

        if (n == 1) return 0;
        //

        for (int i = 0; i < n; i = i + 2) { // 假如奇数是谷
            if (i > 1 && i < n - 1) {
                num1 += nums[i] < Math.min(nums[i - 1], nums[i + 1]) ? 0 : nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1;
            } else if (i == 0) {
                num1 += nums[0] < nums[1] ? 0 : nums[0] - nums[1] + 1;
            } else { // i = n - 1
                num1 += nums[i] < nums[i - 1] ? 0 : nums[i] - nums[i - 1] + 1;
            }
        }

        for (int i = 1; i < n; i = i + 2) { //假如偶数是谷
            if (i < n - 1) {
                num2 += nums[i] < Math.min(nums[i - 1], nums[i + 1]) ? 0 : nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1;
            } else if (i == n - 1) {
                num2 += nums[i] < nums[i - 1] ? 0 : nums[i] - nums[i - 1] + 1;
            }
        }

        return Math.min(num1, num2);
    }
}
