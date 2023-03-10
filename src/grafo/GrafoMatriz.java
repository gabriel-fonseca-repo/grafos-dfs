package grafo;

import abst.Grafo;

public class GrafoMatriz<T> extends Grafo<T> {

    ImpressoraDeMatriz impressoraDeMatriz;

    public GrafoMatriz() {
        this.impressoraDeMatriz = new ImpressoraDeMatriz();
    }

    @Override
    public boolean verificaCiclo() {
        construirMatriz();
        impressoraDeMatriz.imprimirMatrizAdjacencia();
        vertices.get(0).setVisitado(true);
        return verificaCiclo(0);
    }

    protected boolean verificaCiclo(int a) {
        for (int i = a; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    return vertices.get(j).isVisitado() || verificaCiclo(j);
                }
            }
        }
        return false;
    }

    protected void construirMatriz() {
        int n = vertices.size();
        matriz = new int[n][n];

        for (Vertice<T> vertice : vertices) {
            for (Vertice<T> conectado : vertice.getVerticesConectados()) {
                matriz[vertices.indexOf(vertice)][vertices.indexOf(conectado)] = 1;
            }
        }
    }

    private class ImpressoraDeMatriz {

        public void imprimirMatrizAdjacencia() {
            imprimirPrimeiraLinha();
            imprimirMatriz();
        }

        private void imprimirMatriz() {
            int i = 0;
            for (int[] linha : matriz) {
                System.out.print(vertices.get(i).getElemento() + " ");
                for (int coluna : linha) {
                    System.out.print(coluna + " ");
                }
                System.out.println();
                i++;
            }
        }

        private void imprimirPrimeiraLinha() {
            System.out.print("  ");
            for (Vertice<T> vertice : vertices) {
                System.out.print(vertice.getElemento() + " ");
            }
            System.out.println();
        }
    }


}
