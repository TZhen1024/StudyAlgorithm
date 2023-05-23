package Array;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = values[i];
            nums[i][1] = labels[i];
        }
        Arrays.sort(nums, (a, b) -> (b[0] - a[0])); // 按照第一位降序排列

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < n && numWanted > 0; i++) {
            if (!map.containsKey(nums[i][1])) {
                map.put(nums[i][1], useLimit - 1);
            } else if (map.get(nums[i][1]) == 0) {
                continue;
            } else {
                map.compute(nums[i][1], (key, value) -> value - 1);
            }
            sum += nums[i][0];
            numWanted--;
        }
        return sum;
    }
}
