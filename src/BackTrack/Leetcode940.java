package BackTrack;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode940 {
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        System.out.println(distinctSubseqII("aaafahosdignaadjgioagdkmznhizlximzhvizxocvnzkxcvxzvoi"));
    }
    public static int distinctSubseqII(String s) {
        /*
         * 20221014, 9:00
         * 这道题最显而易见的解法就是回溯+HashSet存储
         * 我觉得回溯使没有问题的，但是用HashSet存可能导致爆掉
         * 先写了回溯练习下写法
         * 好像还不能用递归写法
         *
         * 20221014, 16:00
         * 显然我还是天真了，根据标签，这道题是DP，不写了
         */

        int  n = s.length();

        for (int i = 1; i <= n; i++) {
            backTrack(i, s, 0);
        }
        return set.size();
    }

    public static void backTrack(int i, String s, int start) {
        if (sb.length() == i) {
            set.add(sb.toString());
            return;
        }
        for (int j = start; j < s.length(); j++) {
            sb.append(s.charAt(j));
            backTrack(i, s, j + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
