package tree.bt;

import tree.BinaryTree;
import tree.Node;

/**
 * 1.) Inorder
 * 2.) Preorder
 * 3.) Postorder
 *
 *                            5
 *                        10      4
 *                     6      8        9
 *                  1     17
 *              12
 **/
public class BtTraversal {
    public static void main(String[] args) throws Exception {
        Node rootNode = new Node(5, null, null);
        BinaryTree tree = new BinaryTree(rootNode);

        Node node5 = new Node(5, null, null);
        Node node10 = new Node(10, null, null);
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node8 = new Node(8, null, null);
        Node node9 = new Node(9, null, null);
        Node node1 = new Node(1, null, null);
        Node node17 = new Node(17, null, null);
        Node node12 = new Node(12, null, null);

        tree.addNode(rootNode, node4);
        tree.addNode(rootNode, node10);
        tree.addNode(node10, node6);
        tree.addNode(node10, node8);
        tree.addNode(node4, node9);
        tree.addNode(node6, node1);
        tree.addNode(node8, node17);
        tree.addNode(node1, node12);

        tree.printInorderRight();
    }
}
