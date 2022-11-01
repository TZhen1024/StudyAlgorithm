package DynamicProgramming;

/*
    等差数列划分
    自己的解法应该没用动态规划
    官解确实是动态规划
 */
public class Leetcode413 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 7, 9, 2};
        Leetcode413 leetcode413 = new Leetcode413();
        System.out.println(leetcode413.numberOfArithmeticSlices(nums));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;

        int len = 2; // 子数组长度
        int d = nums[1] - nums[0];// 等差数列的公差
        int res = 0;// 返回的结果
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == d) { // 每当i与前一个数的差等于公差，将i纳入等差数组
                len++;
            } else {
                res += (len - 1) * (len - 2) / 2;// i与前一个数的差不等于公差了，计算当前等差数组的子数组数量，加到结果中
                //重置等差数组
                d = nums[i] - nums[i - 1];
                len = 2;
            }
        }
        if (len > 2) {// 最后一个等差数组可能会没有加到结果中，单独处理下
            res += (len - 1) * (len - 2) / 2;
        }
        return res;
    }
}
