package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println((new Leetcode131().partition(s)));
    }

    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s, 0);
        return res;
    }

    public void backTrack(String s, int start) {
        int n = s.length();
        if (start == n) {
            res.add(new ArrayList<String>(list));
            // list.clear();
        }

        for (int i = 1; i <= n - start; i++) { // 遍历从start开始的子串长度（横向）
            if (checkString(s, start, i)) {
                list.add(s.substring(start, start + i)); // 纵向是start的变化
                backTrack(s, start + i);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean checkString(String s, int start, int length) {
        int l = start, r = start + length - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
