# 二分查找
目前的理解：

1. 二分查找while的条件一般是i ≤ j, 然后每次减半的时候，一定要保证答案在缩减的范围内，就是在闭区间[i, j]内。
2. 这个二分查找的终止就是nums[mid]满足要求（这个要求不一定仅仅是与某个数相等，也可以加其他条件，比如这个数的前一位要小于它不能等于它，都可以加），然后返回mid
3. 还有个最重要的条件，就是查找的数组是顺序排列的(找的结果无重复)

```java
public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    int mid = 0;
    while (l <= r) {
        // mid = (l + r) / 2; 用下方写法可以防止溢出（l + r）可能太大
        mid = l + ((r - l) / 2); 
        if (nums[mid] < target) {
            l = mid + 1;
        } else if (nums[mid] > target) {
            r = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}
```