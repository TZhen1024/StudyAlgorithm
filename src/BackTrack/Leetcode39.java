package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode39 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        Leetcode39 leetcode39 = new Leetcode39();
        System.out.println(leetcode39.combinationSum(candidates, target));
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> combination = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // 标签是回溯，先写下回溯
        backTrack(candidates, target, 0);

        return res;
    }

    public void backTrack(int[] candidates, int target, int start) {

        if (sum > target) return;
        else if (sum == target) {
            res.add(new ArrayList(combination));
            return;
        };

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i);
            combination.removeLast();
            sum -= candidates[i];
        }
    }

}
