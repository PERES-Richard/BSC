package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubComplex {
    private List<Protein> proteins;

    SubComplex cloneObject(){
        List<Protein> proteins = new ArrayList<>();
        for(Protein protein : this.proteins){
            proteins.add(protein.cloneObject());
        }
        return new SubComplex(proteins);
    }

    private SubComplex(List<Protein> proteins){
        this.proteins = proteins;
    }

    SubComplex(){
        this.proteins = new ArrayList<>();
    }

    void addProtein(Protein protein) throws Exception{
        if(isContainsProtein(protein))
            throw new Exception("Protein "+protein.getValue()+" is already in sub complex");
        proteins.add(protein);
        Collections.sort(proteins);
    }

    boolean isContainsProtein(Protein protein){
        for(Protein protein1 : proteins){
            if(protein1.equals(protein))
                return true;
        }
        return false;
    }

    Protein getProtein(int value){
        for(Protein p : proteins){
            if(p.getValue() == value)
                return p;
        }
        return null;
    }

    List<Protein> getProteins() {
        return proteins;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Protein protein : proteins){
            builder.append(protein.toString()).append("\t");
        }
        return builder.toString();
    }
}
