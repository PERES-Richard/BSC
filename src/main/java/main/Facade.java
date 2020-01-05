package main;

import java.util.*;

public abstract class Facade {

    private static final int[][] listTP = {
            {20, 10},
            {20, 15},
            {20, 20},
            {30, 10},
            {30, 15},
            {30, 20},
    };

    public static Graph singleGraphe(int p, int t, int algo, int seed, boolean visualisation) throws Exception {
        Graph gi = new Graph(new ComplexGenerator(seed).generate(p, t));

        if (algo == 1)
            gi.algo1alt(false);
        else
            gi.algo2();

        if (visualisation) {
            String filename = String.format("visualisation_graphe_seed_%d_algo_%d_p_%d_t_%d", seed, algo, p, t);
            String uri = gi.image(filename);
            System.out.println("Image crée à l'emplacement :" + uri);
        }

        return gi;
    }


    public static void printTableaux(int NB_ESSAIES, int K_MIN, int K_MAX, int DELTA_MIN, int DELTA_MAX, int algo) throws Exception {
        for (int e = 0; e < listTP.length; e++) {

            System.out.println(String.format("\n\nPour t=%d et p=%d", listTP[e][0], listTP[e][1]));

            List<Integer> kList = new ArrayList<>();
            List<Integer> dList = new ArrayList<>();
            Map<Integer, Integer[]> essaies = new HashMap<>();

            for (int i = 0; i < NB_ESSAIES; i++) {
                Graph gi = new Graph(new ComplexGenerator().generate(listTP[e][0], listTP[e][1]));

                if (algo == 1)
                    gi.algo1alt(false);
                else
                    gi.algo2();

                kList.add(gi.getK());
                dList.add(gi.getDelta());
                essaies.put(i, new Integer[]{gi.edges.size(), gi.getDelta()});
            }

            Collections.sort(kList);
            Collections.sort(dList);

            System.out.println("k min = " + kList.get(0));
            System.out.println("k max = " + kList.get(kList.size() - 1));

            System.out.println("delta min = " + dList.get(0));
            System.out.println("delta max = " + dList.get(dList.size() - 1) + "\n");


            System.out.print("\t");
            for (int k = K_MIN; k <= K_MAX; k += 10)
                System.out.print(String.format("%d\t", k));
            System.out.println();

            for (int d = DELTA_MIN; d < DELTA_MAX; d += 1) {
                System.out.print(String.format("%d\t", d));

                for (int k = K_MIN; k <= K_MAX; k += 10) {
                    System.out.print(String.format("%d\t", stats(k, d, NB_ESSAIES, essaies)));
                }
                System.out.println();
            }
        }
    }


    private static int stats(int k, int d, int NB_ESSAIES, Map<Integer, Integer[]> essaies) {
        int nb = 0;
        for (Map.Entry<Integer, Integer[]> set : essaies.entrySet()) {
            if (set.getValue()[0] <= k && set.getValue()[1] <= d)
                nb++;
        }
        return (int) ((float) nb * 100 / NB_ESSAIES);
    }
}
