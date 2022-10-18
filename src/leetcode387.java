public class leetcode387 {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if ((i + 1 < n && s.indexOf(s.charAt(i), i + 1) == -1) && s.lastIndexOf(s.charAt(i), i - 1) == -1)
                return i;
        }
        return -1;
    }
}
