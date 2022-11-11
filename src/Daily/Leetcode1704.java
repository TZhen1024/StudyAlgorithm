package Daily;

public class Leetcode1704 {
    public static void main(String[] args) {

    }

    public boolean halvesAreAlike(String s) {
        int numOfVowel = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (isVowel(s.charAt(i))) {
                numOfVowel++;
            };

        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                numOfVowel--;
            };
        }
        return numOfVowel == 0;
    }
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
