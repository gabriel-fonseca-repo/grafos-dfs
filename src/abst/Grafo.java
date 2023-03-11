package abst;

import grafo.Vertice;

import java.util.ArrayList;
import java.util.List;

public abstract class Grafo<T> {

    protected List<Vertice<T>> vertices;

    protected int[][] matriz;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public void adicionarVertice(Vertice<T> vertice) {
        this.vertices.add(vertice);
    }

    public abstract boolean verificaCiclo();

    public List<Vertice<T>> getVertices() {
        return this.vertices;
    }

}
