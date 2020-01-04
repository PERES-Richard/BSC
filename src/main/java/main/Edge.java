package main;

public class Edge {
    private Protein begin;
    private Protein end;

    Edge(Protein b, Protein e){
        begin = b;
        end = e;
    }

    public Protein getBegin() {
        return begin;
    }

    public Protein getEnd() {
        return end;
    }

    void incrementDegre(){
        begin.incrementDegree();
        end.incrementDegree();
    }

    @Override
    public boolean equals(Object obj) {
        Edge e = (Edge) obj;
        return (begin.equals(e.begin)&& end.equals(e.end) || begin.equals(e.end)&& end.equals(e.begin));
    }

    @Override
    public String toString() {
        return begin.toString()  + " lié à " + end.toString() + "\n";
    }

    String toDot() {
        return begin.toString()  + " -- " + end.toString() + "\n";
    }
}
