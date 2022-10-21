package SlidingWindow;

import util.MyIntArray;

public class Leetcode713 {
    public static void main(String[] args) {
        int[] nums = MyIntArray.getIntArray();
        int k = 18;

        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        // 有一种想法是最外层循环为滑动窗口的长度，但这种实现有一个问题，就是不知道什么时候滑动窗口就爆了，然后答案就不对了
        // 即使加判断也很困难
        // 因此还是用子数组的起点作为最外层循环

         //1. 暴力写法
        /*for (int start = 0; start < nums.length; start++) {
            int product = 1;
            for (int end = start; end < nums.length; end++) {
                product *= nums[end];
                if (product < k)
                    res++;
                else
                    break;
            }
        }*/
        int l = 0;
        int bl = 0;
        int product = 1;
        for (int start = 0; start < nums.length; start++) {
            while (start + l < nums.length) { //尾部仍在数组范围内
                product *= nums[start + l];
                if (product < k)
                    l++;
                else if (l != 0){
                    res += l * (l + 1) / 2 - bl * (bl + 1) / 2;
                    bl = l - 1;
                    product /= nums[start];
                    product /= nums[start + l];
                    l--;
                    break;
                } else {
                    product /= nums[start];
                    break;
                }
            }
            if (start + l == nums.length)
                res += l * (l + 1) / 2 - bl * (bl + 1) / 2;
        }
        return res;
    }
}
