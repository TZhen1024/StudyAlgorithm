package Hash;

import util.ListNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Leetcode817 {
    public static void main(String[] args) {
        int[] list = new int[]{0, 1, 2, 3};
        int[] nums = new int[]{0, 1, 3};
        ListNode head = ListNode.generateListFromArray(list);
        System.out.println(numComponents(head, nums));
    }
    public static int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int res = 0;
        boolean isEntry = true;
        while (head != null) {
            if (set.contains(head.val) && isEntry) {
                res++;
                isEntry = false;
            } else if (!set.contains(head.val)) {
                isEntry = true;
            }
            head = head.next;
        }
        return res;
    }
}
