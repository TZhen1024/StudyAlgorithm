package StackAndQueue;

import java.util.PriorityQueue;
import java.util.Random;

public class Leetcode215 {
    /*
        topK问题：使用快速选择O(n)/堆（或优先队列）O(nlogn)求解
        许多情况下不用维护全部数据的堆，而是固定容量的堆(比如特别大量的数据，只有很小的空间,在线算法)，动态更新
        需要掌握：优先队列的使用、手写堆
     */

    // 优先队列调库解法，小根堆，大小为k的优先队列
//    public int findKthLargest(int[] nums, int k) {
//        // 使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
//        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);
//        // PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (pq.size() < k) {
//                pq.offer(nums[i]);
//            } else if (pq.size() == k && pq.peek() < nums[i]) {
//                pq.poll();
//                pq.offer(nums[i]);
//            }
//        }
//        return pq.peek();
//    }

    // 手写堆

//    public int findKthLargest(int[] nums, int k) {
//        int n = nums.length;
//        buildKMinHeap(nums, k);
//        for (int i = k; i < n; i++) {
//            if (nums[i] > nums[0]) {
//                swap(nums, 0 , i);
//                minHeapify(nums, 0, k); // 注意这里是0不是i
//            }
//        }
//        return nums[0];
//    }
//
//    // 建立k大小的小根堆
//    public void buildKMinHeap(int[] nums, int heapSize) {
//        for (int i = heapSize / 2; i >= 0; i--) {
//            minHeapify(nums, i , heapSize);
//        }
//    }
//    // 维护堆属性， minHeapify/顶端元素的下移shift-down
//    public void minHeapify(int[] nums, int i, int heapSize) {
//        int left = 2 * i + 1, right = 2 * i + 2, least = i;
//        if (left < heapSize && nums[left] < nums[least]) {
//            least = left;
//        }
//        if (right < heapSize && nums[right] < nums[least]) {
//            least = right;
//        }
//        if (least != i) {
//            swap(nums, least, i);
//            minHeapify(nums, least, heapSize); // 注意这里是least不是i
//        }
//    }
//
//    public void swap (int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    /*
        符合O(n)要求的解法需要使用快速选择的解法，利用快速排序中的partition
        每一次划分，都将pivot调整到它在数组完成排序后的位置（即左边的数字都比它小，右边的数字都比它大）
        因此，在升序排序的过程中，只需要在不断划分的过程中，碰到排序后位置为n-k的情况返回即可
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    // 选择nums排序后在下标k位置的数字
    public int quickSelect(int[] nums, int left, int right, int k) {
        if (left >= right) return nums[k];
        int pivotLoc = partition(nums, left, right);
        if (pivotLoc == k) {
            return nums[pivotLoc];
        } else if (pivotLoc < k) { // 此次明确的位置在k之前
            return quickSelect(nums, pivotLoc + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotLoc - 1, k);
        }
    }
    private final static Random random = new Random(System.currentTimeMillis());

    public int partition(int[] nums, int left, int right) {

        int temp = left + random.nextInt(right - left + 1);
        swap(nums, left, temp);
        int pivotKey = nums[left];
        int initLeft = left;
        while (left < right) {
            while (left <= right && nums[left] <= pivotKey) {
                left++;
            }
            while (left <= right && nums[right] >= pivotKey) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, initLeft, right);
        return right; // 返回这次划分确定的位置

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Leetcode215 leetcode215 = new Leetcode215();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(leetcode215.findKthLargest(nums, 4));
    }
}
