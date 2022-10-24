package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//无重复数字全排列
public class Leetcode46 {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] isVisited = new boolean[nums.length];
        backtrace(nums, isVisited);
        return res;
    }
    public void backtrace(int[] nums, boolean[] isVisited) {
        int n = nums.length;
        if (path.size() == n) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isVisited[i] == false) {
                path.add(nums[i]);
                isVisited[i] = true;
                backtrace(nums, isVisited);
                path.removeLast();
                isVisited[i] = false;
            }
        }
    }
}
