package BackTrack;

import java.util.LinkedList;
import java.util.List;

public class Leetcode22 {
    public static void main(String[] args) {
        int n = 10;
        Leetcode22 leetcode22 = new Leetcode22();
        System.out.println(leetcode22.generateParenthesis(n));
    }

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backTrack(n, n, 0);

        return res;
    }

    // 两种情况，一种是后面直接跟反括号。另一种是之后生成反括号
    public void backTrack(int n, int l, int r) { // l是剩余的左括号, r是剩余的右括号
        if (l == 0) {
            if (sb.length() == 2 * n)
                res.add(sb.toString());
            return;
        }

        // 每一次递归，必须添加左括号
        // 那么每一种组合的不同之处就在于生成几次反括号之后添加左括号
        sb.append('(');
        l--;
        r++;
        for (int i = 0; i <= r; i++) { // 可以生成i次反括号
            for (int j = 0; j < i; j++) {
                sb.append(')');
            }
            backTrack(n, l, r - i);
            for (int j = 0; j < i; j++) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        l++;
        r--;
    }
}
