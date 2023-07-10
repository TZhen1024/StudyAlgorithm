package SlidingWindow;

import java.util.HashMap;

public class Leetcode3 {
    public static void main(String[] args) {
        String s = "abba";
        Leetcode3 leetcode3 = new Leetcode3();
        System.out.println(leetcode3.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 1;
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int res = r - l;

        if (len <= 1) {
            return len;
        }

        map.put(s.charAt(0), 0);
        while (r < len) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                res = Math.max(res, r - l);
                l = map.get(c) + 1;
                map.clear();
                for (int i = l; i <= r; i++) {
                    map.put(s.charAt(i), i);
                }
            } else {
                map.put(c, r);
            }
            r++;
        }

        res = Math.max(res, r - l);
        return res;

    }
}
