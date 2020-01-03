package main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        Protein p1 = new Protein(1);
        Protein p2 = new Protein(2);
        Protein p3 = new Protein(3);
        Protein p4 = new Protein(4);
        Protein p5 = new Protein(5);
        Protein p6 = new Protein(6);

        SubComplex sc1 = new SubComplex();
        sc1.addProtein(p1);
        sc1.addProtein(p2);

        SubComplex sc2 = new SubComplex();
        sc2.addProtein(p2);
        sc2.addProtein(p3);
        sc2.addProtein(p4);

        SubComplex sc3 = new SubComplex();
        sc3.addProtein(p4);
        sc3.addProtein(p5);
        sc3.addProtein(p6);

        ArrayList<SubComplex> datList = new ArrayList<>();
        datList.add(sc1);
        datList.add(sc2);
        datList.add(sc3);
        Complexe c = new Complexe(datList);

    }
}
