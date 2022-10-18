package Hash;

import util.MyIntArray;

import java.util.HashMap;

public class Leetcode1 {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 5, 11};
        int[] res = twoSum(nums, 10);
        MyIntArray.output(res);
    }
    public static int[] twoSum(int[] nums, int target) {
        //HashSet set = new HashSet(Arrays.stream(data).box().collect(Collectors.toList()));
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x) && map.get(x) != i) {
                return new int[]{i, map.get(x)};
            }
        }
        return new int[]{-1, -1};
    }
}
