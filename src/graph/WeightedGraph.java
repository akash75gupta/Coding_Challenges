package graph;

import java.util.*;

public class WeightedGraph {
    private final Map<Vertex, List<Edge>> adjacencyMap = new LinkedHashMap<>();

    public static void main(String[] args) throws Exception {
        //create a graph
        WeightedGraph graph = new WeightedGraph();
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        graph.addEdge(v1, new Edge(5, v2));
        graph.addEdge(v1, new Edge(1, v3));
        graph.addEdge(v2, new Edge(4, v3));
        graph.addEdge(v3, new Edge(2, v4));
        graph.addEdge(v4, new Edge(1, v1));

        graph.print();
    }

    public void addVertex(Vertex v){
        if(!adjacencyMap.containsKey(v)) {
            adjacencyMap.put(v, new ArrayList<>());
        }
    }

    public void addEdge(Vertex source, Edge edge) throws Exception {
        if(edge != null) {
            if (!adjacencyMap.containsKey(source)) {
                throw new Exception("Source vertex does not exist!");
            }
            if (!adjacencyMap.containsKey(edge.getDestination())) {
                throw new Exception("Destination vertex does not exist!");
            }
        }
        adjacencyMap.get(source).add(edge);
    }

    public void print(){
        adjacencyMap.forEach((vertex, neighbours) -> {
            System.out.println();
            System.out.print("Vertex " + vertex.getValue());
            System.out.print(" has edges ");
            neighbours.forEach(System.out::print);
        });
    }

    public List<Edge> getEdges(Vertex vertex) throws Exception {
        if(!adjacencyMap.containsKey(vertex)) {
            throw new Exception("Vertex does not exist!");
        }
        return adjacencyMap.get(vertex);
    }

    public List<Vertex> getVertices() {
        return new ArrayList<>(adjacencyMap.keySet());
    }
}
