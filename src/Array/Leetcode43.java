package Array;

import java.util.Arrays;

public class Leetcode43 {
    public static void main(String[] args) {
        System.out.println(new Leetcode43().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        char[] aArr = num1.toCharArray();
        char[] bArr = num2.toCharArray();
        int aLen = aArr.length;
        int bLen = bArr.length;
        char[] resArr = new char[aLen + bLen - 1]; // 不考虑最大位的进位
        Arrays.fill(resArr, '0');
        StringBuilder sb = new StringBuilder();
        int add = 0;
        for (int i = aLen - 1; i >= 0; i--) {
            int a = aArr[i] - '0';
            for (int j = bLen - 1; j >= 0; j--) {
                int b = bArr[j] - '0';
                int sum = (a * b) + add + (resArr[i + j] - '0');
                // 当前位置
                resArr[i + j] = (char)(sum % 10 + '0');
                // 进位
                add = sum / 10;
            }
            if (add > 0 && i != 0) {
                resArr[i - 1] = (char)(add + '0');
                add = 0;
            }
        }
        if (add > 0) {
            sb.append(add);
        }
        sb.append(resArr);
        return sb.toString();
    }
}
