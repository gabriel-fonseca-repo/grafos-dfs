package util;

import abst.Grafo;
import grafo.Vertice;

import java.util.List;

public class GrafoUtil {

	public static <T> int[][] construirMatriz(Grafo<T> grafo) {
		return construirMatriz(grafo.getVertices());
	}

	public static <T> int[][] construirMatriz(List<Vertice<T>> vertices) {
		int n = vertices.size();
		int[][] matriz = new int[n][n];

		for (Vertice<?> vertice : vertices) {
			int i = vertices.indexOf(vertice);
			for (Vertice<?> conectado : vertice.getVerticesConectados()) {
				matriz[i][vertices.indexOf(conectado)] = 1;
			}
		}
		return matriz;
	}
}
