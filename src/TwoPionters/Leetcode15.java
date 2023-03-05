package TwoPionters;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode15 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 2, -35, 34};
        int[] nums1 = {-1,0,1,2,-1,-4};
        int[] nums2 = {0, 1, 1};
        int[] nums3 = {0, 0, 0};
        int[] nums4 = {0, 0, 0, 0};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
        System.out.println(threeSum(nums4));

    }
    public static List<List<Integer>> threeSum(int[] nums) {

        int i = 0, n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        while (i < n - 2 && nums[i] <= 0) {
            /* 这里仍然是一个二重循环，没有用到排序后的双指针，所以最后跑出来时间比较长
            int j = i + 1;
            while (j < n - 1 && nums[j] + nums[i] <= 0) {
                int k = j + 1;
                while (k < n && nums[j] + nums[i] + nums[k] < 0)
                    k++;
                if (k < n && nums[j] + nums[i] + nums[k] == 0) {
                    List<Integer> now = new LinkedList<>();
                    now.add(nums[i]);
                    now.add(nums[j]);
                    now.add(nums[k]);
                    res.add(now);
                }
                while (j < n - 1 && nums[j + 1] == nums[j])
                    j++;
                j++;
            }
            */
            int target = -nums[i];
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> now = new LinkedList<>();
                    now.add(nums[i]);
                    now.add(nums[left]);
                    now.add(nums[right]);
                    res.add(now);
                    /* 这里不能只走一步，防止重复
                    left++;
                    right--;*/
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
            while (i < n - 2 && nums[i + 1] == nums[i])
                i++;
            i++;
        }
        return res;
    }
}
