package grafo;

import grafo.dirigido.Vertice;
import util.GrafoUtil;

import java.util.ArrayList;
import java.util.List;

public class Grafo<E extends Vertice<T>, T> {

    protected List<E> vertices;
    private int[][] matriz;

    public boolean verificaCiclo() {
        matriz = GrafoUtil.construirMatriz(this);
        GrafoUtil.imprimirMatrizAdjacencia(matriz, this);
        vertices.get(0).setVisitado(true);
        return verificaCiclo(0);
    }

    private boolean verificaCiclo(int a) {
        for (int i = a; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    Vertice<T> temp = vertices.get(j);
                    if (!temp.isVisitado()) {
                        temp.setVisitado(true);
                        return verificaCiclo(j);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public void adicionarVertice(E vertice) {
        this.vertices.add(vertice);
    }

    @SafeVarargs
    public final void adicionarVertice(E... vertice) {
        this.vertices.addAll(List.of(vertice));
    }

    public List<E> getVertices() {
        return this.vertices;
    }

}
