package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 无重复数字 子集
public class Leetcode78 {
    public static void main(String[] args) {

    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> subset = new LinkedList<>();
    /*
    这里写了一个回溯写法，官解提供了位运算解法。
     */
    public List<List<Integer>> subsets(int[] nums) {

        for (int len = 0; len <= nums.length; len++) {
            backTrack(nums, len, 0);
        }
        return res;
    }

    public void backTrack(int[] nums, int len, int start) {
        if (subset.size() == len) {
            res.add(new ArrayList(subset));
        }

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            backTrack(nums, len, i + 1);
            subset.removeLast();
        }

    }
}

// public class Leetcode78 {

//     public static void main(String[] args) {
//         int[] nums = new int[]{1, 2, 3};
//         Leetcode78 leetcode78 = new Leetcode78();
//         leetcode78.subsets(nums);
//         int i = 0;
//         i = i + 1;
//     }

//     List<List<Integer>> res = new ArrayList<>();
//     LinkedList<Integer> subset = new LinkedList<>();
//     public List<List<Integer>> subsets(int[] nums) {
//         backTrack(nums, 0);
//         return res;
//     }

//     public void backTrack(int[] nums, int start) {
//         int n = nums.length;
//         if (start == n) {
//             res.add(new ArrayList<>(subset));
//             return;
//         }

//         backTrack(nums, start + 1);

//         subset.add(nums[start]);
//         backTrack(nums, start + 1);
//         subset.removeLast();
//     }
    
// }