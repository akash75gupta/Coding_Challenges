package tree;

public class ConstructAncestralBinaryTree {
    public static void main(String[] args) {
        AncestralBinaryTreeNode nodeA = new AncestralBinaryTreeNode("A",null);
        AncestralBinaryTreeNode nodeB = new AncestralBinaryTreeNode("B",nodeA);
        AncestralBinaryTreeNode nodeC = new AncestralBinaryTreeNode("C",nodeA);
        AncestralBinaryTreeNode nodeD = new AncestralBinaryTreeNode("D",nodeB);
        AncestralBinaryTreeNode nodeE = new AncestralBinaryTreeNode("E",nodeB);
        AncestralBinaryTreeNode nodeF = new AncestralBinaryTreeNode("F",nodeC);
        AncestralBinaryTreeNode nodeG = new AncestralBinaryTreeNode("G",nodeC);
        AncestralBinaryTreeNode nodeH = new AncestralBinaryTreeNode("H",nodeD);
        AncestralBinaryTreeNode nodeI = new AncestralBinaryTreeNode("I",nodeD);

        AncestralBinaryTreeNode[] nodes = {nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeH, nodeI};

        AncestralBinaryTree ancestralBinaryTree = new AncestralBinaryTree(nodes);

        ancestralBinaryTree.print();

    }
}
