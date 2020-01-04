package main;

public class Protein implements Comparable<Protein>{
    private int value;
    public int degre;

    @Override
    public int compareTo(Protein candidate) {
        return Integer.compare(this.getValue(), candidate.getValue());
    }

    public Protein(int value) {
        this.value = value;
        degre = 0;
    }

    public int getValue() {
        return value;
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
