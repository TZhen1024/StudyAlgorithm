package SlidingWindow;

import util.MyIntArray;

public class Leetcode209 {
    public static void main(String[] args) {
        int target = 396893380;
        int[] nums = MyIntArray.getIntArray();
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        //int[] prefix = new int[nums.length + 1];

        /* 前缀和
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }*/

        // 子数组开头start, 结尾end
        /* 固定右边
        int start = nums.length - 1;
        for (int end = nums.length - 1; end >= 0; end--) {
            while (start >= 0) {
                if (prefix[end + 1] - prefix[start] >= target) {
                    res = Math.min(res, end - start + 1);
                    break;
                }
                start--;
            }
        }*/
        // 固定左边，且不再使用前缀和，速度更快
        int end = 0;
        int sum = 0;
        for (int start = 0; start < nums.length; start++) {
            while (end < nums.length) {
                sum += nums[end];
                if (sum >= target) {
                    res = Math.min(res, end - start + 1);
                    sum -= nums[end];
                    break;
                }
                end++;
            }
            sum -= nums[start];
        }
        if (res > nums.length)
            res = 0;
        return res;
    }
}
