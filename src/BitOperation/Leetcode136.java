package BitOperation;

public class Leetcode136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {1, 4, 2, 2, 1}));
    }
    public static int singleNumber(int[] nums) {
        // 这里用到异或运算 0^1=1
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
