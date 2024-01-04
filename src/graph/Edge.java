package graph;

public class Edge {
    private final int weight;
    private final Vertex destination;

    public Edge(int weight, Vertex destination) {
        this.weight = weight;
        this.destination = destination;
    }

    public Vertex getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", destination=" + destination +
                '}';
    }
}
