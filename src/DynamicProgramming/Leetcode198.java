package DynamicProgramming;

import java.util.HashMap;

public class Leetcode198 {
    public static void main(String[] args) {

    }

    /*
        打家劫舍I
        如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
        class Solution { 记忆化的搜索
            int[] money = new int[101];
            boolean[] isVisited = new boolean[101];
            public int rob(int[] nums) {
                money[1] = nums[0];
                isVisited[1] = true;
                if (nums.length > 1) {
                    money[2] = nums[1];
                    isVisited[2] = true;
                }
                return Math.max(maxMoney(nums, nums.length), maxMoney(nums, nums.length - 1));
            }
            public int maxMoney(int[] nums, int n) {
                if (n < 1)
                    return 0;
                if (isVisited[n] == true)
                    return money[n];
                money[n] = Math.max(maxMoney(nums, n - 2), maxMoney(nums, n - 3)) + nums[n - 1];
                isVisited[n] = true;
                return money[n];
            }
        }
     */
    public int rob1(int[] nums) {
        int n = nums.length;
        /*
           dp[i]表示抢劫从i到n-1的房屋能拿到的最高金额
           dp[n - 1] = nums[n - 1]
           dp[n - 2] = max {nums[n - 2], nums[n - 1]}
           dp[n + 1] = 0
           dp[n] = 0;
           dp[i] = max{ nums[k] + dp[k + 2] }  i=< k <= n - 3
        */
        int[] dp = new int[n + 2];
        dp[n + 1] = 0;
        dp[n] = 0;
        for (int i = n -1; i >= 0; i--) {
            for (int k = i; k < n; k++) {
                dp[i] = Math.max(dp[i], nums[k] + dp[k + 2]);
            }
        }
        return dp[0];
    }

    /*
        第一个房间和最后一个房间相连
     */
    public int rob2(int[] nums) {
        // 偷的过程是，比方说先选第0家再从第2、3、4、5..n - 1家选
        // 假设dp[i]是从第i家开始偷所能拿到的最高金额
        // 那么dp[i] = nums[k] + dp[k + 2]  i =< k <= n - 1 意思是偷了第k家，之后从k+2家开始偷
        // 进一步的，k 的范围可以缩减，因为k = i时求得的金额一定比从i + 2开始偷大，所以k的取值就是i，i + 1
        // 本题要求不能同时偷第一个房间和最后一个房间
        int n = nums.length;
        if (n == 1) return nums[0];
        int first = 0, second = 0;
        int dp0 = 0, dp1 = 0;
        // 不偷最后一家，可以偷第一家
        //int first = Math.max(nums[n - 1], nums[n - 2]), second = nums[n - 2]; // 滚动数组 节省dp数组的空间
        for (int i = n - 2; i >= 0; i--) {
            //dp[i] = Math.max(nums[i] + dp[i + 2], nums[i + 1] + dp[i + 3]);
            dp0 = Math.max(nums[i] + second, first);
            int temp = first;
            first = dp0;
            second = temp;
        }

        // 不偷第一家，可以偷最后一家
        first = 0;
        second = 0;
        for (int i = n - 1; i >= 1; i--) {
            dp1 = Math.max(nums[i] + second, first);
            int temp = first;
            first = dp1;
            second = temp;
        }

        return Math.max(dp0, dp1);
    }

    /*
        房子以二叉树的形式排列
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    HashMap<TreeNode, Boolean> map = new HashMap<>();
    public int rob(TreeNode root) {
        // 上下两层必然会偷一层
        if (map.containsKey(root) && map.get(root)) {
            return root.val;
        }
        if (root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null) {
            map.put(root, true);
            return root.val;
        }

        // 偷root层 mon1， 不偷root层mon2
        int mon1 = root.val, mon2 = 0;
        if (root.left != null) {
            mon1 += (rob(root.left.left) + rob(root.left.right));
            mon2 += rob(root.left);
        }

        if (root.right != null) {
            mon1 += (rob(root.right.left) + rob(root.right.right));
            mon2 += rob(root.right);
        }

        root.val = Math.max(mon1, mon2);
        map.put(root, true);
        return root.val;
    }
}
