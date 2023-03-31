package StackAndQueue;

import Hash.Leetcode15;
import util.MyIntArray;

import java.util.*;

public class Leetcode347 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        Leetcode347 leetcode347 = new Leetcode347();
        MyIntArray.output(leetcode347.topKFrequent(nums,2));
    }

    /* 解法是正确的，但是时间复杂度比较高
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                map.compute(nums[i], (key, value) -> value + 1);
                i++;
            }
            while (!stack1.empty() && map.get(stack1.peek()) < map.get(nums[i])) {
                stack2.push(stack1.pop());
            }
            if (stack1.size() < k)
                stack1.push(nums[i]);
            while (stack1.size() < k && !stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = stack1.pop();
        }
        return res;
    }
    */
    /**
     * 使用优先队列解题，底层实现是大顶堆小顶堆
     * 几种写法都在这里抄一下
     */
    // 写法1 小顶堆，只需要维护一个大小为k的堆
//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
//        }
//
////        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() { // 小顶堆，队列的头元素是最小的
////            @Override
////            public int compare(int[] o1, int[] o2) {
////                return o1[1] - o2[1];
////            }
////        });
//        // 可以采用Lambda来代替new Comparator
//        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1])); // 看运算结果小于等于0的时候是怎么个顺序，优先队列就是什么顺序
//
//        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
//            int num = entry.getKey(), count = entry.getValue();
//            if (queue.size() == k) {
//                if (queue.peek()[1] < count) {
//                    queue.poll();
//                    queue.offer(new int[] {num, count});
//                }
//            } else {
//                queue.offer(new int[] {num, count});
//            }
//        }
//        int[] res = new int[k];
//        for (int i = 0; i < k; ++i) {
//            res[i] = queue.poll()[0];
//        }
//        return res;
//    }
    // 写法2 大顶堆，需要维护全部元素的堆，空间复杂度和时间复杂度都比较高
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new int[] { entry.getKey(), entry.getValue() });
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
