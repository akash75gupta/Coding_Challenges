package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleGraph {
    private final Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        //create a graph
        SimpleGraph graph = new SimpleGraph();

        graph.addEdge(1,2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        graph.print();
    }

    public void addEdge(Integer source, Integer destination) throws Exception {
        if(!adjacencyMap.containsKey(source)) {
            adjacencyMap.put(source, new ArrayList<>());
        }
        if(!adjacencyMap.containsKey(destination)) {
            adjacencyMap.put(destination, new ArrayList<>());
        }
        adjacencyMap.get(source).add(destination);
    }

    public void print(){
        adjacencyMap.forEach((vertex, neighbours) -> {
            System.out.println();
            System.out.print("Vertex " + vertex);
            System.out.print(" has neighbours ");
            neighbours.forEach(neighbour ->{
                System.out.print(neighbour+",");
            });
        });
        System.out.println();
    }

    public List<Integer> getNeighbours(Integer vertex) throws Exception {
        if(!adjacencyMap.containsKey(vertex)) {
            throw new Exception("Vertex does not exist!");
        }
        return adjacencyMap.get(vertex);
    }
}
