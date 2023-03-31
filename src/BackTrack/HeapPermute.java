package BackTrack;

import java.util.ArrayList;

// 1..n全排列
public class HeapPermute {
    static ArrayList<Integer> nums = new ArrayList<>();
    public static void main(String[] args) {
        int n = 3;
        for (int i = 0; i <= n; i++) {
            nums.add(i);
        }
        heapPermute(n);
    }

    public static void heapPermute(int n) {
        if (n == 1) {
            System.out.println(nums);
        } else {
            for (int i = 1; i <= n; i++) {
                heapPermute(n - 1);
                if (n % 2 == 1) {
                    swap(nums, 1, n);
                } else {
                    swap(nums, i, n);
                }
            }
        }
    }

    public static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
