package TwoPoniters;

public class Leetcode11 {
    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height1));
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int res = (j - i) * Math.min(height[i], height[j]);

        while (i < j) {
            int oldI = i, oldJ = j;
            int newCon1 = 0, newCon2 = 0;
            while (i < height.length - 1 && height[i] <= height[oldI])
                i++;
            newCon1 = Math.abs(j - i) * Math.min(height[i], height[j]);

            while (j >= 0 && height[j] <= height[oldJ])
                j--;
            newCon2 = Math.abs(j - oldI) * Math.min(height[oldI], height[j]);

            if (newCon1 > newCon2) {
                res = Math.max(res, newCon1);
                j = oldJ;
            } else {
                res = Math.max(res, newCon2);
                i = oldI;
            }

        }
        return res;
    }
}
