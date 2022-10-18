package BitOperation;

public class Leetcode190 {
    public static void main(String[] args) {
        System.out.println(reverseBits(964176192));
    }
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println("res << i = " + Integer.toBinaryString(res << i));
            System.out.println("n >> i = " + Integer.toBinaryString(n >> i));
            System.out.println("(n >> i) & 1 = " + Integer.toBinaryString((n >> i) & 1));
            res = (res << 1) + ((n >> i) & 1);
        }
        return res;
    }
}
