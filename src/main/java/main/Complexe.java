package main;

import java.util.ArrayList;
import java.util.List;

public class Complexe {
    private List<SubComplex> subComplexes;

    Complexe cloneObject() {
        List<SubComplex> subComplexes = new ArrayList<>();
        for(SubComplex subComplex : this.subComplexes)
            subComplexes.add(subComplex.cloneObject());
        return new Complexe(subComplexes);
    }

    Complexe(List<SubComplex> subComplexes) {
        this.subComplexes = subComplexes;
    }

    List<SubComplex> getConcernedSubComplexes(int v){
        List<SubComplex> concerned = new ArrayList<>();
        for(SubComplex s  : subComplexes){
            if(s.isContainsProtein(new Protein(v))){
                concerned.add(s);
            }
        }
        return  concerned;
    }

    List<SubComplex> getSubComplexes() {
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
