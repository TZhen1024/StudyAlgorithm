package Hash;

import java.util.HashSet;

public class Leetcode349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> setRes = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i]))
                setRes.add(nums2[i]);
        }

        int[] res = new int[setRes.size()];
        int i = 0;
        for (Integer num : setRes) {
            res[i++] = num;
        }
        return res;
    }
}
