package Daily;

public class Leetcode754 {
    public static void main(String[] args) {
        Leetcode754 leetcode754 = new Leetcode754();
        int target = -1;
        System.out.println(leetcode754.reachNumber(target));
    }

    public int reachNumber(int target) {
        int l = 0;
        target = Math.abs(target);
        int r = (int)Math.ceil(Math.sqrt(target * 2)) + 3;
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            int temp = mid * (mid + 1) / 2;
            if (temp == target) {
                return mid;
            } else if (temp < target) {
                l = mid + 1;
            } else {
                int temp2 = mid * (mid - 1) / 2;
                if (temp2 > target) {
                    r = mid - 1;
                } else if (temp2 == target) {
                    return mid - 1;
                } else {
                    break;
                }
            }
        }
        int temp3 = target % 2;
        while ((mid * (mid + 1) / 2 % 2) != temp3) {
            mid++;
        }
        return mid;
    }
}
