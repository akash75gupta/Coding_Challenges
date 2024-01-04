package tree;

public class AncestralBinaryTreeNode {
    private final String name;
    private final AncestralBinaryTreeNode ancestor;

    public AncestralBinaryTreeNode(String name, AncestralBinaryTreeNode ancestor) {
        this.name = name;
        this.ancestor = ancestor;
    }

    public String getName() {
        return name;
    }

    public AncestralBinaryTreeNode getAncestor() {
        return ancestor;
    }

    @Override
    public String toString() {
        return "AncestralBinaryTreeNode{" +
                "name='" + name + '\'' +
                ", ancestor=" + ancestor +
                '}';
    }
}
