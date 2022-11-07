package Daily;

import java.util.LinkedList;
import java.util.List;

public class Leetcode816 {
    public static void main(String[] args) {
        String s = "(100)";
        Leetcode816 leetcode816 = new Leetcode816();
        System.out.println(leetcode816.ambiguousCoordinates(s));
    }

    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s.substring(1, s.length() - 1)); // sb不包含括号
        for (int i = 0; i < sb.length() - 1; i++) { // 在i位置的后一位加“, ”
            List<String> first = new LinkedList<>();
            List<String> second = new LinkedList<>();
            StringBuilder s1 = new StringBuilder(sb.substring(0, i + 1));
            StringBuilder s2 = new StringBuilder(sb.substring(i + 1, sb.length()));
            if (isRightNum(s1.toString())) {
                first.add(s1.toString());
            }
            if (isRightNum(s2.toString())) {
                second.add(s2.toString());
            }
            for (int j = 0; j < s1.length() - 1; j++) { // 在j位置的后一位加“.”
                if (isRightDotNum(s1.toString(), j)) {
                    first.add(s1.insert(j + 1, '.').toString());
                    s1.deleteCharAt(j + 1);
                }
            }
            for (int j = 0; j < s2.length() - 1; j++) { // 在j位置的后一位加“.”
                if (isRightDotNum(s2.toString(), j)) {
                    second.add(s2.insert(j + 1, '.').toString());
                    s2.deleteCharAt(j + 1);
                }
            }
            for (String firstS : first) {
                for (String secondS : second) {
                    res.add("(" + firstS + ", " + secondS + ")");
                }
            }
        }
        return res;
    }

    public boolean isRightNum(String s) { // 在没有小数点的情况下，只要没有前导0就可以
        if (s.charAt(0) == '0' && s.length() > 1)
            return false;
        return true;
    }

    public boolean isRightDotNum(String s, int idx) { // 在idx位置后面加小数点之后，是否是正确的数字形式
        // 前面不要有前导0
        if (s.charAt(0) == '0' && idx > 0) {
            return false;
        }
        // 结尾不能有0
        if (s.charAt(s.length() - 1) == '0') {
            return false;
        }
        return true;
    }
}
