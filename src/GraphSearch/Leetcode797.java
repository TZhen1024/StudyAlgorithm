package GraphSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode797 {
    public static void main(String[] args) {

    }
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 递归DFS吧，迭代的不会写。。。迭代需要标记某个位置已访问过，不太好搞。
        // 感觉更像是回溯，受标签影响了，大差不差吧

        int n = graph.length;
        path.add(0);
        backTrack(0, graph);
        return res;
    }

    public void backTrack(int source, int[][] graph) {
        int n = graph.length;
        if (source == n - 1) {
            res.add(new ArrayList<>(path));
        }

        for (int i = 0; i < graph[source].length && graph[source][i] != 0; i++) {
            path.add(graph[source][i]);
            backTrack(graph[source][i], graph);
            path.removeLast();
        }
    }
}
