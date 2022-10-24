package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode40 {

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        Leetcode40 leetcode40 = new Leetcode40();
        System.out.println(leetcode40.combinationSum2(candidates, target));
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> combination = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 感觉这个组合总和和求子集那个是对应的，要求不能重复，所以进行一个排序，方便之后去重
        Arrays.sort(candidates);

        backTrack(candidates, target, 0);
        return res;
    }

    public void backTrack(int[] candidates, int target, int start) {
        if (sum > target) return;
        else if (sum == target) {
            res.add(new ArrayList(combination));
            return;
        }

        int before = 100;
        for (int i = start; i < candidates.length;) {
            combination.add(candidates[i]);
            sum += candidates[i];
            backTrack(candidates, target, i + 1);
            combination.removeLast();
            sum -= candidates[i];
            before = candidates[i];
            i++;
            while (i < candidates.length && candidates[i] == before) i++;
        }
    }
}
