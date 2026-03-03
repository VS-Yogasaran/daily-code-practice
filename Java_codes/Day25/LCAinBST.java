public class LCAinBST {

    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    static Node lca(Node root, int n1, int n2) {

        if (root == null) return null;

        if (n1 < root.data && n2 < root.data)
            return lca(root.left, n1, n2);

        if (n1 > root.data && n2 > root.data)
            return lca(root.right, n1, n2);

        return root;
    }

    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);

        Node result = lca(root, 5, 15);
        System.out.println("LCA: " + result.data);
    }
}
