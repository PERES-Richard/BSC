package main;

public class Protein implements Comparable<Protein>{
    private int value;
    private int degre;

    Protein cloneObject() {
        return new Protein(value);
    }

    @Override
    public int compareTo(Protein candidate) {
        return Integer.compare(this.getValue(), candidate.getValue());
    }

    Protein(int value) {
        this.value = value;
        degre = 0;
    }

    void incrementDegree(){
        degre++;
    }

    int getValue() {
        return value;
    }

    int getDegre() {
        return degre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Protein test = (Protein) obj;
        return this.value == test.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
