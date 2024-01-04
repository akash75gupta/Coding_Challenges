package graph;

import java.util.*;

public class ShortestPath {
    public static void main(String[] args) throws Exception {
        WeightedGraph graph = new WeightedGraph();

        Vertex v1 = new Vertex(Integer.MAX_VALUE);
        Vertex v2 = new Vertex(Integer.MAX_VALUE);
        Vertex v3 = new Vertex(Integer.MAX_VALUE);
        Vertex v4 = new Vertex(Integer.MAX_VALUE);
        Vertex v5 = new Vertex(Integer.MAX_VALUE);
        Vertex v6 = new Vertex(Integer.MAX_VALUE);

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);

        graph.addEdge(v1, new Edge(7, v2));
        graph.addEdge(v2, new Edge(6, v3));
        graph.addEdge(v2, new Edge(20, v4));
        graph.addEdge(v3, new Edge(14, v4));
        graph.addEdge(v4, new Edge(2, v5));
        graph.addEdge(v5, null);
        graph.addEdge(v6, null);

        graph.print();

        Map<Vertex, Integer> shortestPaths = findShortestPossiblePaths(graph, v1);
    }

    private static Map<Vertex, Integer> findShortestPossiblePaths(WeightedGraph graph, Vertex start) throws Exception {
        Map<Vertex, Integer> shortestPath = new HashMap<>();
        graph.getVertices().forEach(v->{
            shortestPath.put(v, Integer.MAX_VALUE);
        });
        shortestPath.put(start, 0);

        Set<Vertex> visited = new HashSet<>();

        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(start);

        while(!priorityQueue.isEmpty()) {
           Vertex current = priorityQueue.remove();
           visited.add(start);
           graph.getEdges(current).forEach(edge -> {
               Vertex neighbour = edge.getDestination();
               if(!visited.contains(neighbour)) {
                   priorityQueue.add(neighbour);
                   int cost = edge.getWeight() + current.getValue();
                   if (shortestPath.get(neighbour) > cost) {
                       shortestPath.put(neighbour, cost);
                   }
               }
           });

        }
        return null;
    }
}
