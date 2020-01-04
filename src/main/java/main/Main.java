package main;

public class Main {

    public static void main(String[] args) throws Exception {
        ComplexGenerator generator = new ComplexGenerator();
        Complexe complexe = generator.generate(5, 2);
        System.out.println(complexe);
        Graph g = new Graph(complexe);
        g.algo1();
        g.printGraph();
        g.printNumberEdges();
    }
}
