package main;

public class Main {

    public static void main(String[] args) throws Exception {
        ComplexGenerator generator = new ComplexGenerator();
        Graph g = new Graph(generator.generate(50, 5));
        g.algo1();
        g.printGraph();
    }
}
