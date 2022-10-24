package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
// 有重复数字 子集
public class Leetcode90 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    // 这里还是写个回溯，对78的代码进行些许更改
    static List<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> subset = new LinkedList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // 注意这里进行排序
        Arrays.sort(nums);
        for (int len = 0; len <= nums.length; len++) {
            backTrack(nums, len, 0);
        }

        return res;
    }

    public static void backTrack(int[] nums, int len, int start) {
        if (subset.size() == len) {
            res.add(new ArrayList(subset));
            return;
        }

        int before = 100;
        for (int i = start; i < nums.length;) {
            subset.add(nums[i]);
            backTrack(nums, len, i + 1);
            subset.removeLast();
            before = nums[i];
            i++;
            while (i < nums.length && nums[i] == before) {
                i++;
            }
        }
    }
}

/*

[4,4,4,1,4]
 */