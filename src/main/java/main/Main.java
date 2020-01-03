package main;

public class Main {

    public static void main(String[] args) throws Exception {
        ComplexGenerator generator = new ComplexGenerator(14);
        System.out.println(generator.generate(3, 2));
    }
}
