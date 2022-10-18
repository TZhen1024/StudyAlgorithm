package util;

public class MyIntArray {
    public static void output (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void output(int[][] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            if (i != 0)
                System.out.print(" ");
            System.out.print("[");
            for (int j = 0; j < nums[i].length - 1; j++) {
                System.out.print(nums[i][j] + ", ");
            }
            System.out.print(nums[i][nums[i].length - 1] + "]");
            if (i != nums.length - 1)
                System.out.println();
        }
        System.out.println("]");
    }
}
