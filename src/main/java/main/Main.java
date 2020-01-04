package main;

public class Main {

    public static void main(String[] args) throws Exception {
        ComplexGenerator generator = new ComplexGenerator(21);
        Complexe complexe = generator.generate(3, 3);
        System.out.println(complexe);
        Graph g = new Graph(complexe);
        g.algo1();
        g.printGraph();
        g.printNumberEdges();
        g.image("algo1");


        Graph g2 = new Graph(new ComplexGenerator(21).generate(3, 3));
        g2.algo2();
        g2.printGraph();
        g2.printNumberEdges();
        g2.image("algo2");
    }
}
