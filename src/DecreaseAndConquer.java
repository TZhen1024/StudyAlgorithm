public class DecreaseAndConquer {

    static int[] nums;
    public static void main(String[] args) {
        nums = new int[]{1,2,3,0,5};
        System.out.println(minElementLocation(nums.length));
    }

    public static int minElementLocation(int n) {
        if (n == 1)
            return 0;
        int x = minElementLocation(n - 1);
        if (nums[x] > nums[n-1]) {
            return n-1;
        } else {
            return x;
        }
    }
}
