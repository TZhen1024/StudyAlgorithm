package Array;

public class Leetcode27 {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums1 = new int[] {3, 2, 2, 3};
        int[] nums2 = new int[] {0, 0, 3, 3, 3};
        int[] nums3 = new int[] {3, 3, 3, 0, 0};
        int[] nums4 = new int[] {2};
        Leetcode27 leetcode27 = new Leetcode27();
        System.out.println(leetcode27.removeElement(nums4, 3));
    }

    public int removeElement(int[] nums, int val) {
        // 应该可以用双指针做
        // 这里使用的是头尾异向的指针，也有同向快慢指针的做法，参见代码随想录（leetcode官解方法一也是快慢指针）
        int i = 0, j = nums.length - 1;
        while (i <= j) { // 这里是小于等于，nums4测试用例不过，第一次进入的时候i可能等于j，之后就不可能了，因为i位置是下一个等于val的位置，j是下一个不等于val的位置
            while (nums[i] != val && (++i) < nums.length);
            while (nums[j] == val && (--j) >= 0);

            if (i < j) {
                swap(nums, i, j);
            }

        }
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
