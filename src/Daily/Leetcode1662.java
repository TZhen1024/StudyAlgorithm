package Daily;

/*
    2022/11/01 Easy
 */
public class Leetcode1662 {
    public static void main(String[] args) {
        Leetcode1662 leetcode1662 = new Leetcode1662();
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};
        System.out.println(leetcode1662.arrayStringsAreEqual(word1, word2));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String word : word1) {
            sb1.append(word);
        }
        for (String word : word2) {
            sb2.append(word);
        }

        // 注意这里不能用sb1.equals(sb2), equals在未重写的情况下，用来表示两个对象是否是同一个对象
        // compareTo用来比较两个StringBuilder的字符序列, 但由于有字典序的比较，所以会慢一点
        // 也可以返回sb1.toString().equals(sb2.toString()) 或者 new String(sb1).equals(new String(sb2))
        return sb1.compareTo(sb2) == 0 ? true : false;
    }
}
