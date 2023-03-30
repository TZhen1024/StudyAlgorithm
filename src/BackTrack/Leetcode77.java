package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode77 {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> combination = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(1, n, k);
        return res;
    }

    public void backTracking(int start, int end, int k) { // [start, end]是可选数字的范围，k是剩余需要选的数字数量
        if (k == 0) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i = start; i <= end - k + 1; i++) {
            combination.add(i);
            backTracking(i + 1, end, k - 1);
            combination.removeLast();
        }
    }
}
