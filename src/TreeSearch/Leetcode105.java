package TreeSearch;

public class Leetcode105 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }
    public static void main(String[] args) {
        int[] preorder = new int[] {3, 9, 20, 15, 7};
        int[] inorder = new int[] {9, 3, 15, 20, 7};
        Leetcode105 leetcode105 = new Leetcode105();

        leetcode105.buildTree(preorder, inorder);    
    }

    int mid = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        
        int midVal = preorder[mid];
        TreeNode root = new TreeNode(midVal);
        mid++; // 此时min指向需要考虑的新的中间节点

        int i = start;
        while (i < end && inorder[i] != midVal) i++; // 此时i为左子树在inorder数组中的end
       
        TreeNode left, right;
        if (mid < preorder.length && start < i && i < end) {
            left = buildTree(preorder, inorder, start, i);
            root.left = left;
        }
        if (mid < preorder.length && i + 1 < end) {
            right = buildTree(preorder, inorder, i + 1, end);
            root.right = right;
        }
        
        return root;
    }
}
