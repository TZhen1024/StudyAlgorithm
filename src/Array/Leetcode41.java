package Array;

import java.util.Arrays;

public class Leetcode41 {

    public static void main(String[] args) {
        int[] nums = new int[] {-1,4,2,1,9,10};
        Leetcode41 leetcode41 = new Leetcode41();
        System.out.println(leetcode41.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        // 通过交换使得正整数在符合其下标的位置 比如说数字1的下标一定是0
        // 那么第一个不符合这个规则的，就是要找的最小正整数
        // Hash的思想，其实[1,2,0]这个示例就是一个提示
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // nums[nums[i] - 1] != nums[i]这一条件包含（nums[i] != i + 1），因此只需保留nums[nums[i] - 1] != nums[i]，避免[1,1]情况下死循环
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) { //【易错】这里不可以用if判断只做一次调整，例如[-1,4,2,1,9,10]，在调整4的时候，把1调整了
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

}
