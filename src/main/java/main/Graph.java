package main;

import java.util.*;

public class Graph {
    List<Edge> edges;
    Complexe initial;

    public Graph(Complexe c){
        edges = new ArrayList<>();
        initial = c;
    }

    public void algo1(){
        int[] occurences = new int[101]; // initialized at 0 by default, on compte le nombre d'occurence d'une protéine pour détermine si elle est multiple ou unique
        for(SubComplex s : initial.getSubComplexes()){
            for(Protein p : s.getProteins()){
                occurences[p.getValue()] += 1;
            }
        }

        Map<SubComplex,List<Protein>> uniques = new HashMap<>();
        Map<SubComplex, List<Protein>> multiples = new HashMap<>();
        for(SubComplex s : initial.getSubComplexes()){
            uniques.put(s, new ArrayList<>());
            multiples.put(s, new ArrayList<>());
        }
        for(int i = 1; i< occurences.length ; i++){ //On repère les uniques et multiples d'un assemblage
            System.out.println("Occurences de " + i + " : " +occurences[i]);
            if(occurences[i] == 1){
                uniques.get(initial.getConcernedSubComplexes(i).get(0)).add(initial.getConcernedSubComplexes(i).get(0).getProtein(i));
            }
            else if (occurences[i] > 1){
                for(SubComplex s : initial.getConcernedSubComplexes(i)){
                    multiples.get(s).add(s.getProtein(i));
                }
            }
        }

        for (Map.Entry<SubComplex, List<Protein>> entry : uniques.entrySet()) { //Affichage only
            System.out.println("####UNIQUES");
            System.out.println(entry.getKey()+" : ");
            for(Protein p : entry.getValue()){
                System.out.println(p);
            }
            System.out.println("UNIQUES#####");
        }

        for (Map.Entry<SubComplex, List<Protein>> entry : multiples.entrySet()) { //Affichage only
            System.out.println("####MULTIPLES");
            System.out.println(entry.getKey()+" : ");
            for(Protein p : entry.getValue()){
                System.out.println(p);
            }
            System.out.println("MULTIPLES#####");
        }

        for(SubComplex s : initial.getSubComplexes()){ //On lie les prots uniques entre elles, et les prots multiples entre elles
            for(int i = 0; i< uniques.get(s).size()-1; i++) {
                Edge un = new Edge(uniques.get(s).get(i),uniques.get(s).get(i+1));
                un.incrementDegre();
                edges.add(un);


            }

            for(int i = 0; i< multiples.get(s).size()-1; i++) {
                Edge mul = new Edge(multiples.get(s).get(i),multiples.get(s).get(i+1));
                if(!edges.contains(mul)){
                    mul.incrementDegre();
                    edges.add(mul);
                }
            }
        }

        for(SubComplex s : initial.getSubComplexes()){ //On lie les protéines uniques aux protéines multiple d'un assemblage
            if(uniques.get(s).size() > 0 && multiples.get(s).size() > 0){
            Comparator<Protein> compareDegree = new Comparator<Protein>() { // On utilise un comparator pour trouver les sommets avec le plus petit degrés pour faire le lien
                @Override
                public int compare(Protein o1, Protein o2) {
                    return Integer.compare(o1.degre, o2.degre);
                }
            };
            Edge unmul = new Edge(Collections.min(uniques.get(s), compareDegree),Collections.min(multiples.get(s), compareDegree));
            if(!edges.contains(unmul)){
                unmul.incrementDegre();
                edges.add(unmul);
            }
            }
        }
    }

    public void printGraph(){
        for(Edge e : edges){
            System.out.println(e);
        }
    }

}
