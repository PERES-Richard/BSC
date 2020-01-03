package main;

import java.util.ArrayList;
import java.util.List;

public class SubComplex {
    private List<Protein> proteins;

    public SubComplex(List<Protein> proteins) {
        this.proteins = proteins;
    }

    public SubComplex(){
        this.proteins = new ArrayList<>();
    }

    public void addProtein(Protein protein) throws Exception{
        for(Protein protein1 : proteins){
            if(protein1.equals(protein))
                throw new Exception("Protein "+protein.getValue()+" is already in sub complex");
        }
        proteins.add(protein);
    }

    public List<Protein> getProteins() {
        return proteins;
    }
}
