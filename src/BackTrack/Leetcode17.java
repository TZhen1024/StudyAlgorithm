package BackTrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Leetcode17 {
    public static void main(String[] args) {
        String digits = "2583";
        Leetcode17 leetcode17 = new Leetcode17();
        System.out.println(leetcode17.letterCombinations(digits));
    }

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    HashMap<Character, char[]> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        backTrack(digits, 0);

        return res;
    }

    public void backTrack(String digits, int num) {
        if (sb.length() == digits.length()) {
            if (digits.length() != 0)
                res.add(sb.toString());
            return;
        }

        char[] letters = map.get(digits.charAt(num));

        for (int i = 0; i < letters.length; i++) {
            sb.append(letters[i]);
            backTrack(digits, num + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
