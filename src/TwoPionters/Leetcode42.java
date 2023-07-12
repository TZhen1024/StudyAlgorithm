package TwoPionters;

public class Leetcode42 {

    public static void main(String[] args) {
        int[] height = new int[] {4,2,3};
        Leetcode42 leetcode42 = new Leetcode42();
        System.out.println(leetcode42.trap(height));
    }

    public int trap(int[] height) {
        /*
            双指针解法
            承接雨水的【凹陷】出现在数值下降又上升的位置，一味上升或一味下降不会出现凹陷
            用一个变量作为预期凹陷包含的雨水
            l, r作为凹陷的左右墙壁
         */

        int n = height.length;
        if (n < 3) return 0;

        int l = 0, r = 1;
        int temp = 0, res = 0;

        while (r < n) {
            if (height[r] >= height[l]) {
                res += temp;
                l = r;
                r++;
                temp = 0;
            } else if (height[r] < height[l]) {
                temp += height[l] - height[r];
                r++;
            }
        }

        if (l < n - 1) {
            int end = l;
            l = n - 2;
            r = n - 1;
            temp = 0;
            while (l >= end) {
                if (height[l] >= height[r]) {
                    res += temp;
                    r = l;
                    l--;
                    temp = 0;
                } else {
                    temp += height[r] - height[l];
                    l--;
                }
            }
        }
        return res;
    }
}
