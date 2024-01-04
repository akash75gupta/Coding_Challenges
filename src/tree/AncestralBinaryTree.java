package tree;

import java.util.Arrays;

public class AncestralBinaryTree {
    private final AncestralBinaryTreeNode[] nodes;

    public AncestralBinaryTree(AncestralBinaryTreeNode[] nodes) {
        this.nodes = nodes;
    }

    public AncestralBinaryTreeNode[] getNodes() {
        return nodes;
    }

    public void print(){
        Arrays.asList(nodes).forEach(System.out::println);
    }
}
