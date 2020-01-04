package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Integer> kList = new ArrayList<>();
        List<Integer> dList = new ArrayList<>();
        for (int i = 0; i < 15000; i++) {
            Graph gi = new Graph(new ComplexGenerator().generate(10, 20));
            gi.algo1(false);
            gi.printNumberEdges();
            kList.add(gi.getEdges().size());
            dList.add(gi.getDelta());
        }

        Collections.sort(kList);
        Collections.sort(dList);

        System.out.println("k min = " + kList.get(0));
        System.out.println("k max = " + kList.get(kList.size()-1));

        System.out.println("delta min = " + dList.get(0));
        System.out.println("delta max = " + dList.get(dList.size()-1));


//        for (int k = 10; k < 100; k += 10) {
//            for (int d = 2; d < 10; d++) {
////                System.out.print(stats(k, d) + " ");
//            }
//            System.out.println();
//        }

    }
}
