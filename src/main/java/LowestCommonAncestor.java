/**
 * Created by akumar6 on 7/20/15.
 */
public class LowestCommonAncestor {

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String args[]) {
        Node root = new Node(10, null, null);
        root.left = new Node(5, null, null);
        root.right = new Node(15, null, null);
        root.left.left = new Node(4, null, null);
        root.left.right = new Node(6, null, null);
        root.right.left = new Node(14, null, null);
        root.right.right = new Node(20, null, null);
        root.right.left.left = new Node(13, null, null);
        root.right.left.left.left = new Node(12, null, null);
        System.out.println(findLCMNode(root,6,20).value);
    }

    private static Node findLCMNode(Node node, int value1, int value2) {
        if (node == null) {
            return null;
        }
        if (node.value == value1 && node.value == value2) {
            return node;
        }
        if (node.value > value1 && node.value > value2) {
            return findLCMNode(node.left, value1, value2);
        }
        if (node.value < value1 && node.value < value2) {
            return findLCMNode(node.right, value1, value2);
        }
        return node;

    }
}
