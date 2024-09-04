package ForDebug;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode78 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Leetcode78 leetcode78 = new Leetcode78();
        leetcode78.subsets(nums);
        int i = 0;
        i = i + 1;
    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> subset = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return res;
    }

    public void backTrack(int[] nums, int start) {
        int n = nums.length;
        if (start == n) {
            res.add(new ArrayList<>(subset));
            return;
        }

        backTrack(nums, start + 1);

        subset.add(nums[start]);
        backTrack(nums, start + 1);
        subset.removeLast();
    }
    
}


