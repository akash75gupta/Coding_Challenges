package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private final Map<Vertex, List<Vertex>> adjacencyList = new HashMap<>();

    public static void main(String[] args) throws Exception {
        //create a graph
        Graph graph = new Graph();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, v2);
        graph.addEdge(v1, v3);
        graph.addEdge(v2, v3);
        graph.addEdge(v3, v4);
        graph.addEdge(v4, v1);

        graph.print();
    }

    public void addVertex(Vertex v){
        if(!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    public void addEdge(Vertex source, Vertex destination) throws Exception {
        if(!adjacencyList.containsKey(source)) {
            throw new Exception("Source vertex does not exist!");
        }
        if(!adjacencyList.containsKey(destination)) {
            throw new Exception("Destination vertex does not exist!");
        }
        adjacencyList.get(source).add(destination);
    }

    public void print(){
        adjacencyList.forEach((vertex, neighbours) -> {
            System.out.println();
            System.out.print("Vertex " + vertex.getValue());
            System.out.print(" has neighbours ");
            neighbours.forEach(neighbour ->{
                System.out.print(neighbour.getValue() +",");
            });
        });
    }

    public List<Vertex> getNeighbours(Vertex vertex) throws Exception {
        if(!adjacencyList.containsKey(vertex)) {
            throw new Exception("Vertex does not exist!");
        }
        return adjacencyList.get(vertex);
    }
}
