package Array;

public class Leetcode287 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 3, 4};
        System.out.println(new Leetcode287().findDuplicate_bit(nums));
    }
    public int findDuplicate_bit(int[] nums) {
        int n = nums.length; // 注意这里的数组长度是n，而题中数组长度是n + 1
        int ans = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }

        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                ans |= 1 << bit;
            }
        }

        return ans;
    }

}
