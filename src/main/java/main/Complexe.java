package main;

import java.util.List;

public class Complexe {
    private List<SubComplex> subComplexes;

    Complexe(List<SubComplex> subComplexes) {
        this.subComplexes = subComplexes;
    }

    public List<SubComplex> getSubComplexes() {
        return subComplexes;
    }

    @Override
    public String toString() {
        StringBuilder builder =  new StringBuilder();
        builder.append("Le complexe a ").append(subComplexes.size()).append(" sous-complexes :\n");
        for (int i = 0; i < subComplexes.size(); i++) {
            builder.append("- Sous-complexe ").append(i).append(" : ").append(subComplexes.get(i).toString()).append("\n");
        }
        return builder.toString();
    }
}
