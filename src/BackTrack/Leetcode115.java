package BackTrack;

import java.util.HashMap;
import java.util.HashSet;
/*
 * 20221014, 16:00
 * 使用回溯写了很长一段时间，也尝试各种优化，最终还是不行（54/63，TLE）
 * 根据标签，这是一道动态规划，我决定暂时战略性放弃了
 */
public class Leetcode115 {
    static StringBuilder sb = new StringBuilder();
    static int res = 0;
    //static HashMap<Character, HashMap<Integer, Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        String s =
                "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
        String t = "bcddceeeebecbc";
        //res = 700531452
//        String s = "babgbag";
//        String t = "bag";
        System.out.println(s.length());
        System.out.println(t.length());
        System.out.println(numDistinct(s, t));
    }
    public static int numDistinct(String s, String t) {

        int  n = t.length();
       /* HashMap<Character, Integer> lastCharLocation = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                HashMap<Integer, Integer> newMap = new HashMap<>();
                newMap.put(-1, i);
                lastCharLocation.put(c, i);
                map.put(c, newMap);
            } else {
                map.get(c).put(lastCharLocation.get(c), i);
                lastCharLocation.put(c, i);
            }
        }*/
        backTrack(n, s, t,0);

        return res;
    }

    public static void backTrack(int i, String s, String t, int start) {
        if (sb.length() == i) { // 终止条件是串的长度与t的长度相同
            res++;
            return;
        }
        char c = t.charAt(sb.length());
        for (int j = start; j != -2 && j < s.length(); j++) {  // j需要从start开始，start前面的字符不再使用，因为肯定已经遍历过了
//            while (j < s.length() && s.charAt(j) != t.charAt(sb.length()))   // 如果j位置的字符不是t的下一个字符，就j++，直到找到或者j=s.length()
//                j++;
           // j = fistCharFromJ(c, j);
            j = s.indexOf(t.charAt(sb.length()), j);
            if (j == -1 || s.length() - j < i - sb.length())
                return;
            sb.append(s.charAt(j));
            backTrack(i, s, t, j + 1);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
    /*public static int fistCharFromJ(char c, int j) {
        int i = -1;
        while (i != -2 && (i = nextChar(c, i)) < j);
        return i;
    }

    public static int nextChar(char c, int last) {
        if (map.get(c) == null ||  map.get(c).get(last) == null)
            return -2;
        return map.get(c).get(last);
    }*/
}

