package TwoPionters;

public class Leetcode844 {
    public static void main(String[] args) {
        String s = "bbbextm";
        String t = "bbb#extm";
        System.out.println(backspaceCompare(s, t));
    }
    /*
     * 这个题要求O(1)的空间
     * 1. 第一种思路是直接在原有空间上进行数据的修改，但是由于原数据是字符串没法直接更改，所以作罢，如果是数组可能可以
     * 2. 因为不能修改，所以可行的方案只想到模拟，在模拟的时候不能正向而要反向，因为回退符不影响其后面的字符，那么从后往前就可以比较字符
     * 3. 遇到回退符就记个数，因为对于回退符及其之前的字符，只要文本不为空，回退符就可以发挥作用。对于回退符之后的字符，我们已经判断了是否相等。
     */
    public static boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1, tIndex = t.length() - 1;
        int sDelete = 0, tDelete = 0;

        while (sIndex >= 0 || tIndex >= 0) {
            // 在当前字符是回退符或者回退仍有存量的时候，需要进行回退
            while (sIndex >= 0 && (sDelete != 0 || s.charAt(sIndex) == '#')) {
                if (s.charAt(sIndex) == '#')
                    sDelete++;
                else
                    sDelete--;
                sIndex--;
            }
            while (tIndex >= 0 && (tDelete != 0 || t.charAt(tIndex) == '#')) {
                if (t.charAt(tIndex) == '#')
                    tDelete++;
                else
                    tDelete--;
                tIndex--;

            }

            if (sIndex == -1 && tIndex == -1)
                return true;
            else if ((sIndex == -1 && tIndex != -1) || (sIndex != -1 && tIndex == -1))
                return false;
            else if (s.charAt(sIndex) != t.charAt(tIndex))
                return false;

            sIndex--;
            tIndex--;
        }

        return true;
    }
}
