package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public static void main(String[] args) {
        int[] nums = new int[] {-4, -1, -1, 0, 1, 2};
        Leetcode15 leetcode15 = new Leetcode15();
        leetcode15.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 整体思想就是，定住一个数(三元组中最大的或最小的)，然后这道题就变成了双指针求解两数之和
        // 采用双指针的方法求两数之和，是O(n)的复杂度，定住的数循环，所以整个算法是O（n^2)
        // 首先要进行排序
        Arrays.sort(nums);
        int n = nums.length;
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) { // 定住最小的
            int l = i + 1, r = n - 1;
            while (l < r) {
                int temp = nums[l] + nums[r];
                if (temp + nums[i] < 0) {
                    l++;
                } else if (temp + nums[i] > 0) {
                    r--;
                } else {
                    ArrayList<Integer> array = new ArrayList<>();
                    array.add(nums[i]);
                    array.add(nums[l]);
                    array.add(nums[r]);
                    res.add(array);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) l++; // 去重，避免取到相同答案
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;
        }
        return res;
    }
}
