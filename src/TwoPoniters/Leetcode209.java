package TwoPoniters;

import java.util.Arrays;

public class Leetcode209 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] nums1 = new int[]{2,3,1,2,4,3};
        int[] nums2 = new int[]{1,4,4};
        int[] nums3 = new int[]{1,1,1,1,1,1,1,1};
        int target = 11;
        Leetcode209 leetcode209 = new Leetcode209();
        System.out.println(leetcode209.minSubArrayLen(target, nums3));
    }

    public int minSubArrayLen(int target, int[] nums) {
        // 连续子数组，数组元素的相对位置不能改变，不能排序
        // 那么应该就是滑动窗口了
        int start = 0, end = 0;
        int sum = 0;
        int minLen = nums.length + 1;
        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= target) {
                minLen = Math.min(minLen, end - start);
                sum -= nums[start++];
            }
        }
        if (minLen == nums.length + 1) {
            return 0;
        }
        return minLen;
    }
}
