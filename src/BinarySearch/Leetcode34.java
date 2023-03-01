package BinarySearch;

public class Leetcode34 {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        if (nums.length == 0) return new int[] {-1, -1};
        while (l <= r) {
            mid = l + ((r - l) / 2);
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (mid == 0 || nums[mid - 1] < target) {
                break;
            } else {
                r = mid - 1;
            }
        }
        if (nums[mid] != target) return new int[] {-1, -1};
        int res1 = mid;
        while (mid < nums.length && nums[mid] == nums[res1]) {
            mid++;
        }
        return new int[] {res1, mid - 1};
    }
}
