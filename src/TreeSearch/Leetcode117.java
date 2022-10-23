package TreeSearch;

class Leetcode117 {

    private class Node {
        int val;
        Node left;
        Node right;
        Node next;

        Node() {}

        Node(int _val) {
            val = _val;
        }

        Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next= _next;
        }
    }
    static void main(String[] args) {

    }

    static Node connect(Node root) {
        if (root == null)
            return null;

        Node leftmost =  null;

        Node now = root;

        Node before = null;

        while (now != null) {
            if (now.left != null) {
                if (before != null) {
                    before.next = now.left;
                } else {
                    leftmost = now.left;
                }
                before = now.left;
            }
            if (now.right != null) {
                if (before != null) {
                    before.next = now.right;
                } else {
                    leftmost = now.right;
                }
                before = now.right;
            }
            now = now.next;

        }

        connect(leftmost);
        return root;
    }

}
