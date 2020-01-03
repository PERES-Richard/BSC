package main;

import java.util.List;

public class Complexe {
    public List<SubComplex> subComplexes;

    public Complexe(List<SubComplex> subComplexes) {
        this.subComplexes = subComplexes;
    }

    @Override
    public String toString() {
        StringBuilder builder =  new StringBuilder();
        builder.append("Le graph a ").append(subComplexes.size()).append(" sous-complexes :\n");
        for (int i = 0; i < subComplexes.size(); i++) {
            builder.append("- Sous-complexe ").append(i);
            builder.append("\t").append(subComplexes.toString());
        }
        return builder.toString();
    }
}
