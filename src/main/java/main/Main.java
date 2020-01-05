package main;

import java.util.*;

public class Main {

    private static Map<Integer, Integer> essaies;
    private final static int NB_ESSAIES = 1000;
    private final static int K_MIN = 100;
    private final static int DELTA_MIN = 6;

    public static void main(String[] args) throws Exception {
        List<Integer> kList = new ArrayList<>();
        List<Integer> dList = new ArrayList<>();
        essaies = new HashMap<>();

        for (int i = 0; i < NB_ESSAIES; i++) {
            Graph gi = new Graph(new ComplexGenerator().generate(10, 20));
            gi.algo1alt(false);
            gi.printNumberEdges();
            kList.add(gi.getEdges().size());
            dList.add(gi.getDelta());
            essaies.put(gi.edges.size(), gi.getDelta());
        }

        Collections.sort(kList);
        Collections.sort(dList);

        System.out.println("k min = " + kList.get(0));
        System.out.println("k max = " + kList.get(kList.size() - 1));

        System.out.println("delta min = " + dList.get(0));
        System.out.println("delta max = " + dList.get(dList.size() - 1) + "\n");


        System.out.print("\t");
        for (int k = K_MIN; k <= K_MIN+100; k += 10)
            System.out.print(String.format("%d\t", k));
        System.out.println();

        for (int d = DELTA_MIN; d < DELTA_MIN+10; d += 1) {
            System.out.print(String.format("%d\t", d));

            for (int k = K_MIN; k <= K_MIN+100; k += 10) {
                System.out.print(String.format("%d\t", stats(k, d)));
            }
            System.out.println();
        }

    }

    private static int stats(int k, int d) {
        int nb = 0;
        for (Map.Entry<Integer, Integer> set : essaies.entrySet()) {
            if (set.getKey() <= k && set.getValue() <= d)
                nb++;
        }
        return (int)((float) nb*100 / NB_ESSAIES);
    }
}
