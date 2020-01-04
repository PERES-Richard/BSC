package main;

public class Edge {
    public Protein begin;
    public Protein end;

    public Edge(Protein b, Protein e){
        begin = b;
        end = e;

    }

    public void incrementDegre(){
        begin.degre +=1;
        end.degre +=1;
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
}
