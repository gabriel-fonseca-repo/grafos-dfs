package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo<T> {
    private final List<Vertice<T>> vertices;
    private int[][] matriz;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public void adicionarVertice(Vertice<T> vertice) {
        this.vertices.add(vertice);
    }

    public boolean verificaCiclo() {
        construirMatriz();
        imprimirMatrizAdjacencia(matriz);
        vertices.get(0).setVisitado(true);
        return verificaCiclo(0);
    }

    private boolean verificaCiclo(int a) {
        for (int i = a; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    return vertices.get(j).isVisitado() || verificaCiclo(j);
                }
            }
        }
        return false;
    }

    private void construirMatriz() {
        int n = vertices.size();
        this.matriz = new int[n][n];

        for (Vertice<T> vertice : vertices) {
            List<Vertice<T>> adjacentes = vertice.getVerticesConectados();
            for (Vertice<T> conectado : adjacentes) {
                matriz[vertices.indexOf(vertice)][vertices.indexOf(conectado)] = 1;
            }
        }
    }

    @SuppressWarnings("unused")
    private void imprimirMatrizAdjacencia(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int coluna : linha) {
                System.out.print(coluna + " ");
            }
            System.out.println();
        }
    }
}
