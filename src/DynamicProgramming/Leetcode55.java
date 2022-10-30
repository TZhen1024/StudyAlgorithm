package DynamicProgramming;

public class Leetcode55 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        Leetcode55 leetcode55 = new Leetcode55();
        System.out.println(leetcode55.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        /*
           只要不遇到0, 都是可以到达最后一个下标的
           而有0的，只要能把0跳过去就行
           正着来是我从下标0考虑下一步跳哪
           倒着求解是，当前位置能否到达最后一个下标，可以通过其后位置能够到达最后一个下标来减少计算
           假设dp[i]为true表示从i位置可以到达最后一个下标
           若nums[i] == 0, 则dp[i] = false
           否则 dp[i] = dp[i + 1] | dp[i + 2] | ... | dp[i + nums[i]]

           有时候感觉dp像是带有最优思想的记忆化搜索
        */
        int n = nums.length;
        boolean[] dp = new boolean[n];
        if (n == 1)
            return true;
        dp[n - 1] = true;
        dp[n - 2] = nums[n - 2] == 0 ? false : true;
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] == 0) { // 这个判断其实可以省略
                dp[i] = false;
            } else if (i + nums[i] >= n - 1){
                dp[i] = true;
            } else {
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}
