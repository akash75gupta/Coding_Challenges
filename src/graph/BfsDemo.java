package graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class BfsDemo {
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

        bfsIterative(graph, start);
    }

    private static void bfsIterative(SimpleGraph graph, Integer start) throws Exception {
        Set<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int vertex = queue.removeFirst();
            System.out.println("Visiting vertex: "+vertex);
            graph.getNeighbours(vertex).forEach(n->{
                if(!visited.contains(n)){
                    queue.addLast(n);
                    visited.add(n);
                }
            });
        }
    }
}
