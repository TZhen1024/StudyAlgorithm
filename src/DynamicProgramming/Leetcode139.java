package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode139 {
    public static void main(String[] args) {

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // 顺着来就行了
        // dp[i] 表示从下标0到下标i的字符串能否由字典中的单词拼接
        // 存一个dp[i]为true的列表，比如其中有一个下标为k
        // 那么如果我算dp[j]， 就只需要看是否存在子串（k, j)与字典中的单词相同

        HashSet<String> set = new HashSet<>(wordDict);
        ArrayList<Integer> trueList = new ArrayList<>();
        trueList.add(0);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // for (int k : trueList) {
            //     if (set.contains(s.substring(k, i + 1))) {
            //         trueList.add(i + 1);
            //         break;
            //     }
            // }
            int j =trueList.size() - 1;
            for (; j >= 0; j--) {
                int k = trueList.get(j);
                if (set.contains(s.substring(k, i + 1))) {
                    trueList.add(i + 1);
                    break;
                }
            }

        }

        if (trueList.get(trueList.size() - 1) == n) {
            return true;
        } else {
            return false;
        }
    }
}
