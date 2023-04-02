package util;

import grafo.Grafo;
import grafo.dirigido.Vertice;

import java.util.List;

public class GrafoUtil {

    public static <T, E extends Vertice<T>> int[][] construirMatriz(Grafo<E, T> grafo) {
        return construirMatriz(grafo.getVertices());
    }

    public static <T, E extends Vertice<T>> int[][] construirMatriz(List<E> vertices) {
        int n = vertices.size();
        int[][] matriz = new int[n][n];

        for (E vertice : vertices) {
            int i = vertices.indexOf(vertice);
            for (Vertice<T> conectado : vertice.getVerticesConectados()) {
                matriz[i][vertices.indexOf(conectado)] = 1;
            }
        }
        return matriz;
    }

    public static <T, E extends Vertice<T>> void imprimirMatrizAdjacencia(int[][] matriz, Grafo<E, T> grafo) {
        List<E> vertices = grafo.getVertices();
        imprimirCabecalhoMatriz(grafo.getVertices());

        int i = 0;
        for (int[] linha : matriz) {
            System.out.print((vertices.get(i).getRotulo() != null ? vertices.get(i).getRotulo() : vertices.get(i).getElemento()) + " ");
            for (int coluna : linha) {
                System.out.print(coluna + " ");
            }
            System.out.println();
            i++;
        }
    }

    private static <T, E extends Vertice<T>> void imprimirCabecalhoMatriz(List<E> vertices) {
        System.out.print("  ");
        for (Vertice<T> verticeForte : vertices) {
            System.out.print((verticeForte.getRotulo() != null ? verticeForte.getRotulo() : verticeForte.getElemento()) + " ");
        }
        System.out.println();
    }
}
