package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 有重复数字全排列
public class Leetcode47 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    static List<List<Integer>> res = new LinkedList<>();
    static LinkedList<Integer> permute = new LinkedList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        backTrack(nums, isVisited);
        return res;
    }


    public static void backTrack(int[] nums, boolean[] isVisited) {
        if (permute.size() == nums.length) {
            res.add(new ArrayList(permute));
            return;
        }

        int before = 100;
        for (int i = 0; i < nums.length;) {
            if (!isVisited[i]) {
                permute.add(nums[i]);
                isVisited[i] = true;
                backTrack(nums, isVisited);
                permute.removeLast();
                isVisited[i] = false;
                before = nums[i];
            }
            i++;
            while (i < nums.length && nums[i] == before) i++;
        }

    }
}
