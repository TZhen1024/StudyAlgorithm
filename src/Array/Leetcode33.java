package Array;

public class Leetcode33 {
    // 初步想法是两次二分查找
    // 第一次二分找到两段的分界（前半段最大的数/唯一一个比前后的数都大的数）
    // 第二次二分找到target
    public int search(int[] nums, int target) {
        int index = binarySearch(nums);
        if (target >= nums[0]) {
            return binarySearch(nums, 0, index, target);
        } else  {
            return binarySearch(nums, index + 1, nums.length - 1, target);
        }
    }

    public int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2; // l + (r - l) / 2
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[n - 1]) { // 说明mid在第二段，mid成为新的右边界
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return n - 1 ;
    }

    public static void main(String[] args) {
        Leetcode33 leetcode33 = new Leetcode33();
        int[] nums = new int[]{5, 1, 3};
        System.out.println(leetcode33.search(nums, 1));
    }
}
