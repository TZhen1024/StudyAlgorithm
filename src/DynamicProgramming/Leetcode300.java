package DynamicProgramming;

public class Leetcode300 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,10,4,3,8,9};

        Leetcode300 leetcode300 = new Leetcode300();
        System.out.println(leetcode300.lengthOfLIS(nums));
    }

//    public int lengthOfLIS(int[] nums) {
//        // 初步的想法是，dp[i]表示以i为起始最长递增子序列的长度
//        // dp解法，此dp解法相较于暴力的解法，好处就在于利用了一些重叠子问题的记忆
//        // 所以有时候dp并不能够带来时间复杂度数量级上的优化，而是利用记忆化的方式，对其进行适当的优化
//        int n = nums.length;
//        int[] dp = new int[n];
//
//        dp[n - 1] = 1;
//        int res = dp[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            dp[i] = 1;
//            for (int j = i + 1; j < n; j++) {
//                if (nums[j] > nums[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    public int lengthOfLIS(int[] nums) { // https://leetcode.cn/problems/longest-increasing-subsequence/solutions/24173/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
        // 官解写法更好理解些。
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) { // 没有明确的说tails[m]是小于num且最接近num的数，但是在二分不断逼近的过程中，一定得到这一结果
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num; // tails和官解d数组是一个作用
            // 此时i和j相等，考虑i和j相邻的时候，假设一个是n，一个是n+1，平均值为n
            // 所以i（n)只可能向前挪一位或者j(n+1)向后挪一位，i == j退出循环。
            if(res == j) res++;
        }
        return res;
    }
}
