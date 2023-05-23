package TreeSearch;

public class Leetcode1080 {
    private class TreeNode {
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

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (lastOrderVisit(root, limit, 0)) {
            return root;
        } else {
            return null;
        }
    }

    // 函数返回值为boolean, false代表不足，当前节点的子树中只要有一个是足的，那么我这个节点就是足的
    public boolean lastOrderVisit(TreeNode root, int limit, int sum) {// sum初始为0
        boolean isLeftSufficient = false;
        boolean isRightSufficient = false;
        sum = sum + root.val;

        if (root.left == null && root.right == null) {
            if (sum < limit)
                return false;
            else
                return true;
        }

        if (root.left != null) {
            isLeftSufficient = lastOrderVisit(root.left, limit, sum);
            if (!isLeftSufficient) {
                root.left = null;
            }
        }

        if (root.right != null) {
            isRightSufficient = lastOrderVisit(root.right, limit, sum);
            if (!isRightSufficient) {
                root.right = null;
            }
        }

        return isLeftSufficient || isRightSufficient;
    }
}
