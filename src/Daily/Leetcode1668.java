package Daily;

/*
    2022/11/03 Easy
    暴力了，但是根据官解可以用KMP，如下教程
    https://oi-wiki.org/string/kmp/

    在进行暴力的时候，也注意到temp = i， i = temp这里可能是不需要回退到原位置的，而是可以回退到一个更靠后的位置
    也许可以使用KMP算法完成目的
 */
public class Leetcode1668 {
    public static void main(String[] args) {
        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba", word = "aaaba";
        Leetcode1668 leetcode1668 = new Leetcode1668();
        System.out.println(leetcode1668.maxRepeating(sequence, word));
    }

    public int maxRepeating(String sequence, String word) {
        int res = 0;
        int ns = sequence.length();
        int nw = word.length();
        for (int i = 0; i < ns - nw + 1; i++) {
            int now = 0;
            if (sequence.charAt(i) == word.charAt(0)) {
                int temp = i;
                while (i < ns - nw + 1 && (sequence.substring(i, i + nw)).equals(word)) {
                    now++;
                    i = i + nw;
                }
                res = Math.max(res, now);
                i = temp;
            }
        }

        return res;
    }
}
