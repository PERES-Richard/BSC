package main;

import java.util.List;

public class Graph {
    public List<SubComplex> subComplexes;

    public Graph(List<SubComplex> subComplexes) {
        this.subComplexes = subComplexes;
    }

    @Override
    public String toString() {
        StringBuilder builder =  new StringBuilder();
        builder.append("Le graph a " + subComplexes.size() + " sous-complexes :\n");
        for (int i = 0; i < subComplexes.size(); i++) {
            builder.append("- Sous-complexe " + i);
            builder.append("\t" + subComplexes.toString());
        }
        return builder.toString();
    }
}
