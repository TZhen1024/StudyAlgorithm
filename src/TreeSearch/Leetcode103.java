package TreeSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Leetcode103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /*
            此问题的难点在于，访问节点的顺序与节点添加孩子的顺序是相反的
            比如一个3层满二叉树[1,2,3,4,5,6,7], 在第2层，访问节点的顺序是3->2,
            但是添加节点孩子的顺序是先添加2的孩子（4->5）,再添加3的孩子（6->7)

            所以按照锯齿顺序去访问节点，同时使用栈调转节点添加孩子的顺序

            【易错】 在使用栈的时候，需要注意压栈的时候可能栈中还有上一层的元素，所以
            先用一个队列把这一层需要入栈的元素存起来，最后统一入栈

         */
        boolean flag = true; // true 代表从左往右
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        stack.push(root);

        ArrayList<Integer> array1 = new ArrayList<>();
        array1.add(root.val);
        res.add(array1); // 在元素入栈的时候，就已经把元素的值填到结果中。

        while (!stack.isEmpty()) {
            int size = stack.size();
            TreeNode temp;
            ArrayList<Integer> array = new ArrayList<>();
            ArrayDeque<TreeNode> que = new ArrayDeque<>();
            for (int i = 0; i < size && flag; i++) { // 从右到左访问节点
                temp = stack.pop(); // 出栈的顺序，就是节点添加孩子的顺序
                if (temp.right != null) { // 首先访问右节点
                    que.offer(temp.right); // 将右节点暂存到que中，之后统一压栈，如果直接stack.push(temp.right)则栈中可能仍有前一层的节点。
                    array.add(temp.right.val);
                }
                if (temp.left != null) {
                    que.offer(temp.left);
                    array.add(temp.left.val);
                }
            }

            for (int i = 0; i < size && !flag; i++) { // 从左到右访问节点
                temp = stack.pop();
                if (temp.left != null) {
                    que.offer(temp.left);
                    array.add(temp.left.val);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                    array.add(temp.right.val);
                }
            }

            while (!que.isEmpty()) {
                stack.push(que.poll());
            }
            flag = !flag;
            if (array.size() != 0) // 因为是在元素入栈的时候填结果，所以最后一次会有空array
                res.add(array);
        }
        return res;
    }
}
