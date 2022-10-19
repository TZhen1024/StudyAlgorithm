package util;

import java.util.*;

public class MyIntArray {
    public static void output (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
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

    public static List<Integer> getIntArray(int type) {
        ArrayList<Integer> arr = new ArrayList<>();
        LinkedList<Integer> link = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            String s = scan.nextLine();
            if (s.length() == 0) {
                System.out.println("This is a \\n, scanner close.");
            } else {
                String[] sList = s.substring(1, s.length() - 1).split(",");
                for (int i = 0; i < sList.length; i++) {
                    arr.add(Integer.parseInt(sList[i].trim()));
                    link.add(Integer.parseInt(sList[i].trim()));
                }
            }
        }
        scan.close();
        if (type == 0)
            return arr;
        else
            return link;
    }

    public static int[] getIntArray() {
        ArrayList<Integer> arr = (ArrayList) getIntArray(0);
        Integer[] res = arr.toArray(new Integer[arr.size()]);
        return Arrays.stream(res).mapToInt(Integer::valueOf).toArray();
    }

}
