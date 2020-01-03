package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComplexGenerator {
    private static final int NB_SOMMETS = 100;
    private Random r;

    ComplexGenerator(int seed) {
        this.r = new Random(seed);
    }

    public ComplexGenerator() {
        r = new Random();
    }

    /**
     * Génere un nouveau complexe procéduralement
     *
     * @param p Nombre de protéines dans chaque sous-complexes
     * @param t Nombre de sous-complexes
     * @return Le complexe généré
     */
    Complexe generate(int p, int t) throws Exception {
        List<SubComplex> subComplexes = new ArrayList<>();
        List<Protein> proteinList = generateProtein();


        for (int i = 0; i < t; i++) {
            SubComplex currSub = new SubComplex();

            for (int j = 0; j < p; j++) {
                Protein currP = proteinList.get(r.nextInt(NB_SOMMETS));

                while (currSub.isContainsProtein(currP))
                    currP = proteinList.get(r.nextInt(NB_SOMMETS));

                currSub.addProtein(currP);
            }

            subComplexes.add(currSub);
        }

        return new Complexe(subComplexes);
    }

    private List<Protein> generateProtein() {
        List<Protein> proteinList = new ArrayList<>();

        for (int i = 0; i < NB_SOMMETS; i++) {
            proteinList.add(new Protein(i + 1));
        }

        return proteinList;
    }
}
