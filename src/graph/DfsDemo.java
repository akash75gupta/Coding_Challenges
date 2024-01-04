package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class DfsDemo {
    public static void main(String[] args) throws Exception {
        //create a graph
        SimpleGraph graph = new SimpleGraph();

        graph.addEdge(1,2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        graph.print();

        Integer start = 4;

        System.out.println("Doing a depth first search iteratively");
        dfsIterative(graph, start);
        Set<Integer> visited = new HashSet<>();
        System.out.println("Doing a depth first search recursively");
        dfsRec(graph, start, visited);
    }

    private static void dfsIterative(SimpleGraph graph, Integer start) throws Exception {
        Set<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(start);
        visited.add(start);
        while(!stack.isEmpty()){
            int vertex = stack.removeLast();
            System.out.println("Visiting vertex: "+vertex);
            graph.getNeighbours(vertex).forEach(n->{
                if(!visited.contains(n)){
                    stack.addLast(n);
                    visited.add(n);
                }
            });
        }
    }
    private static void dfsRec(SimpleGraph graph, Integer start, Set<Integer> visited) throws Exception {
        if(visited != null) {
            visited.add(start);
            System.out.println("Visiting vertex: "+start);
        }
        graph.getNeighbours(start).forEach(n->{
            assert visited != null;
            if(!visited.contains(n)){
                try {
                    dfsRec(graph, n, visited);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
