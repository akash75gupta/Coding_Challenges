package graph;

public class Vertex implements Comparable<Vertex>{
    private Integer value;

    public Vertex(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Vertex{" +
                "value=" + value +
                '}';
    }
    @Override
    public int compareTo(Vertex comparingVertex) {
        return this.value - comparingVertex.getValue();
    }
}
