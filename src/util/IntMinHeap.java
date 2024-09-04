package util;

public class IntMinHeap {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,3,1,2,4,5,5,6};
        // 测试堆的建立
        IntMinHeap intMinHeap = new IntMinHeap(nums);
        System.out.print("建好的堆：");
        intMinHeap.print();
        System.out.println();

        // 测试poll方法
        System.out.print("从堆中一个个Poll元素：");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(intMinHeap.poll() + " ");;
        }
        System.out.println();
        System.out.print("Poll完之后，堆中为空");
        intMinHeap.print(); // 这时堆中应该为空
        System.out.println();

        // 测试offer方法
        for (int i = 0; i < nums.length; i++) {
            intMinHeap.offer(nums[i]);
        }
        System.out.print("Offer完之后，堆的内容：");
        intMinHeap.print();
        System.out.println();

    }
    int heapSize;
    private static final int DEFAULT_INITIAL_CAPACITY = 100;
    int[] heap = new int[DEFAULT_INITIAL_CAPACITY]; // 简单起见，这里将heap的最大大小设置为100

    public IntMinHeap() {
        heapSize = 0;
    }
    public IntMinHeap(int[] nums) {
        heapSize = nums.length;
        System.arraycopy(nums, 0, heap, 0, heapSize);
        for (int i = heapSize >>> 1; i >= 0; i--) {
            shiftDown(i); // i位置的数据进行下沉
        }
    }

//    public void shiftDown(int i) {  // 对i位置的数据进行下沉
//        int left = (i << 1) + 1, right = (i + 1) << 1;
//        int least = i;
//        if (left < heapSize && heap[left] < heap[least]) {
//            least = left;
//        }
//        if (right < heapSize && heap[right] < heap[least]) {
//            least = right;
//        }
//        if (least != i) {
//            swap(least, i);
//            shiftDown(least); // 此时least位置存的是一开始要下沉的数据，要下沉的数据一直都是这一个
//        }
//    }
    // 迭代写法
//    public void shiftDown(int i) {
//        while ((i << 1) + 1 < heapSize) {
//            int left = (i << 1) + 1, right = (i + 1) << 1;
//            int least = i;
//            if (left < heapSize && heap[left] < heap[least]) {
//                least = left;
//            }
//            if (right < heapSize && heap[right] < heap[least]) {
//                least = right;
//            }
//
//            if (least == i)
//                break;
//            swap(i, least);
//            i = least;
//        }
//    }
    public void shiftDown(int i) {
        int half = heapSize >>> 1;
        int key = heap[i];
        while (i < half) {
            int child = (i << 1) + 1, right = (i + 1) << 1;
            int c = heap[child];
            if (right < heapSize && heap[right] < c)
                c = heap[child = right];
            if (c >= key)
                break;
            heap[i] = c;
            i = child;
        }
        heap[i] = key;
    }
//    递归写法
//    public void shiftUp(int i) {
//        int father = (i - 1) >> 1;
//        if (father >= 0 && heap[father] > heap[i]) {
//            swap(father, i);
//            shiftUp(father);
//        }
//    }
    // 迭代写法
//    public void shiftUp(int i) {
//        int key = heap[i];
//        if (i == 0) // 当前位置就是堆顶，无法再上浮
//            return;
//        int father = (i - 1) >>> 1;
//        while (father >= 0 && heap[father] > key) {
//            heap[i] = heap[father];
//            i = father;
//            if (father == 0) {
//                break;
//            }
//            father = (i - 1) >>> 1;
//        }
//        heap[i] = key;
//    }
    // JDK源码优先队列写法
    public void shiftUp(int i) {
        int key = heap[i];
        while (i > 0) {
            int father = (i - 1) >>> 1;
            if (heap[father] < key) {
                break;
            }
            heap[i] = heap[father];
            i = father;
        }
        heap[i] = key;
    }
    public int peek() { // 返回堆顶元素
        return heap[0];
    }

    public void offer(int val) {
        if ((++heapSize) > DEFAULT_INITIAL_CAPACITY) // 不支持扩容
            return;
        heap[heapSize - 1] = val;
        shiftUp(heapSize - 1);
    }

    public int poll() {
        int ans = peek();
        swap(0, --heapSize); // 堆首位与末位交换，同时堆大小减一
        shiftDown(0);
        return ans;
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void print() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
