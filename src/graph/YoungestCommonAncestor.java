package graph;

import tree.AncestralBinaryTreeNode;

import java.util.*;

public class YoungestCommonAncestor {
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

        String youngestCommonAncestor = youngestCommonAncestor(nodeA, nodeB, nodeB);

        System.out.println(youngestCommonAncestor);
    }

    /**
     * Most optimized code
     * @param rootNode
     * @param node1
     * @param node2
     * @return
     */
    private static String youngestCommonAncestor(AncestralBinaryTreeNode rootNode, AncestralBinaryTreeNode node1, AncestralBinaryTreeNode node2) {
       int depth1 = depth(rootNode, node1);
       int depth2 = depth(rootNode, node2);

       if(depth2 > depth1){
           int diff = depth2 - depth1;
           while(diff != 0){
               node2 = moveUp(node2);
               diff--;
           }
       }else if (depth1 > depth2){
           int diff = depth1 - depth2;
           while(diff != 0){
               node1 = moveUp(node1);
               diff--;
           }
       }

       while(node1 != node2){
           node1 = moveUp(node1);
           node2 = moveUp(node2);
       }

       return node1.getName();
    }

    /**
     * Moves up the tree by one level from the given node
     * @param targetNode
     * @return AncestralBinaryTreeNode
     */
    private static AncestralBinaryTreeNode moveUp(AncestralBinaryTreeNode targetNode) {
        return targetNode.getAncestor();
    }

    private static int depth(AncestralBinaryTreeNode rootNode, AncestralBinaryTreeNode targetNode) {
        int depth = 0;
        while(targetNode != rootNode){
            targetNode = moveUp(targetNode);
            depth++;
        }
        return depth;
    }

    /**
     * TODO
     */
    private static String youngestCommonAncestorWithExtraSpace(AncestralBinaryTreeNode nodeA,
                                                               AncestralBinaryTreeNode nodeE,
                                                               AncestralBinaryTreeNode nodeI) {
        Map<AncestralBinaryTreeNode, Integer> visitCount = new LinkedHashMap<>();
        dfs(nodeA, nodeE, visitCount);
        dfs(nodeA, nodeI, visitCount);
        return null;
    }


    private static void dfs(AncestralBinaryTreeNode nodeA, AncestralBinaryTreeNode nodeE, Map<AncestralBinaryTreeNode, Integer> visitCount) {

    }
}
