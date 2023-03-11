package grafo;

import abst.Grafo;
import util.OutputUtil;

public class GrafoMatrAdj<T> extends Grafo<T> {

    @Override
    public boolean verificaCiclo() {
        construirMatriz();
        OutputUtil.imprimirMatrizAdjacencia(matriz, this);
        vertices.get(0).setVisitado(true);
        return verificaCiclo(0);
    }

    protected boolean verificaCiclo(int a) {
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

    protected void construirMatriz() {
        int n = vertices.size();
        matriz = new int[n][n];

        for (Vertice<T> vertice : vertices) {
            int i = vertices.indexOf(vertice);
            for (Vertice<T> conectado : vertice.getVerticesConectados()) {
                matriz[i][vertices.indexOf(conectado)] = 1;
            }
        }
    }
}