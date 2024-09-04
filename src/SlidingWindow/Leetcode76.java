package SlidingWindow;

public class Leetcode76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Leetcode76().minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        String res = "";
        if (sLen < tLen) {
            return res;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        int[] sNum = new int[128];
        int[] tNum = new int[128];

        for (int i = 0; i < tLen; i++) {
            tNum[tArr[i]]++;
        }

        int distance = 0;
        int minLen = Integer.MAX_VALUE;
        int begin = 0;
        // [left, right)
        int left = 0, right = 0;
        while (right < sLen) {

            // 在未找到覆盖子串时，不断扩展右边界
            while (distance != tLen && right < sLen) {
                char ch = sArr[right];
                // 当ch不在tArr中时，tNUm[ch] == 0, 下面条件判断一定不成立，distance不变
                // 当ch的出现次数小于等于tNum[ch]时，说明此次增加是有效的，distance++
                if (++sNum[ch] <= tNum[ch]) {
                    distance++;
                }
                right++;
            }

            // 此时找到了一个较长的覆盖子串，需要缩减左边界
            while (distance == tLen) {
                char ch = sArr[left];
                if (tNum[ch] != 0 && sNum[ch] == tNum[ch]) { // 说明此时ch一旦去掉就不满足覆盖子串了
                    if (right - left < minLen) {
                        minLen = right - left;
                        begin = left;
                    }
                    //sNum[ch]--;
                    distance--;
                }
                sNum[ch]--; //这里是必须的，因为过程中存在sNum[ch] > tNum[ch]的情况，此时ch去掉仍满足覆盖子串，但相应sNum需要减一
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return res;
        }
        res = s.substring(begin, begin + minLen);
        return res;
    }
}
