package tree;

import java.util.*;

/**
 * 1.) Inorder
 * 2.) Preorder
 * 3.) Postorder
 *
 *                            5
 *                        10        4
 *                     6      8  9
 *                  1     17
 *              12
 **/
public class BinaryTree {
    private final Node rootNode;

    public BinaryTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "rootNode=" + rootNode +
                '}';
    }

    public void addNode(Node parentNode, Node childNode) throws Exception {
        if(parentNode.getLeft() == null){
            parentNode.setLeft(childNode);
        }else if(parentNode.getRight() == null){
            parentNode.setRight(childNode);
        }else{
            throw new Exception("Given parent node is full. Try with a different node!");
        }
    }

    public void printInorderRight() {
        List<Node> visible = new ArrayList<>();

        Set<Node> visited = new HashSet<>();
        Map<Node, Integer> depth = new HashMap<>();
        depth.put(rootNode, 0);

        System.out.println(rootNode);
        visited.add(rootNode);

        Stack<Node> stack = new Stack<>();
        stack.add(rootNode);

        int maxDepth = 0;

        while(!stack.isEmpty()){
            Node currentNode = stack.peek();
            Node rightNode = currentNode.getRight();
            Node leftNode = currentNode.getLeft();
            if(rightNode != null && !visited.contains(rightNode)){
                int currentDepth = depth.get(currentNode)+1;
                depth.put(rightNode, currentDepth);
                currentNode = rightNode;
                visited.add(currentNode);
                stack.add(currentNode);
                if(maxDepth < currentDepth) {
                    maxDepth = currentDepth;
                    visible.add(currentNode);
                }
                System.out.println("Current Depth: "+currentDepth);
                System.out.println(currentNode);
            }else if(leftNode != null && !visited.contains(leftNode)){
                int currentDepth = depth.get(currentNode)+1;
                depth.put(leftNode, currentDepth);
                currentNode = leftNode;
                visited.add(currentNode);
                stack.add(currentNode);
                if(maxDepth < currentDepth) {
                    maxDepth = currentDepth;
                    visible.add(currentNode);
                }
                System.out.println("Current Depth: "+currentDepth);
                System.out.println(currentNode);
            }else{
                stack.remove(currentNode);
            }
        }
    }

    public void printInOrderLeft() {

    }

    public void printPreOrder() {

    }

    public static void main(String[] args) throws Exception {
        Node rootNode = new Node(5, null, null);
        BinaryTree tree = new BinaryTree(rootNode);

        Node node10 = new Node(10, null, null);
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, null, null);
        Node node8 = new Node(8, null, null);
        Node node9 = new Node(9, null, null);
        Node node1 = new Node(1, null, null);
        Node node17 = new Node(17, null, null);
        Node node12 = new Node(12, null, null);

        tree.addNode(rootNode, node10);
        tree.addNode(rootNode, node4);
        tree.addNode(node10, node6);
        tree.addNode(node10, node8);
        tree.addNode(node4, node9);
        tree.addNode(node6, node1);
        tree.addNode(node8, node17);
        tree.addNode(node1, node12);

        tree.printInorderRight();
    }
}
