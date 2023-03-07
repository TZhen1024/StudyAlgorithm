package Hash;

public class Leetcode242 {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length())
            return false;
        int[] letters = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            letters[s.charAt(i) - 'a']++;
            letters[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0)
                return false;
        }
        return true;
    }
}
