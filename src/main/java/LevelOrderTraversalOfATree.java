import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalOfATree {

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
        Node root1 = root;
        printTree(root);
        printTreeWithQueue(root1);
        System.out.println("Print in order:");

    }

    public static void printTree(Node root) {
        Node copy = root;
        int height = getHeight(copy);
        System.out.println("Height of tree is :" + height);
        for (int i = 1; i <= height; i++) {
            printLevel(root, i);
            System.out.println("");
        }
    }

    private static void printLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.print(node.value + "+++");
        } else {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    public static void printTreeWithQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            while (levelNodes > 0) {
                Node removedNode = queue.remove();
                System.out.print(removedNode.value + "+++");
                if (removedNode.left != null) {
                    queue.add(removedNode.left);
                }
                if (removedNode.right != null) {
                    queue.add(removedNode.right);
                }
                levelNodes--;
            }
            System.out.println("");

        }

    }

    private static int getHeight(Node tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(tree.left), getHeight(tree.right));
    }

}
