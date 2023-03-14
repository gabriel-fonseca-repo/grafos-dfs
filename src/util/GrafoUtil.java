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

	public static <T> void imprimirMatrizAdjacencia(int[][] matriz, Grafo<T> grafo) {
		List<Vertice<T>> vertices = grafo.getVertices();
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

	private static <T> void imprimirCabecalhoMatriz(List<Vertice<T>> vertices) {
		System.out.print("  ");
		for (Vertice<T> vertice : vertices) {
			System.out.print((vertice.getRotulo() != null ? vertice.getRotulo() : vertice.getElemento()) + " ");
		}
		System.out.println();
	}
}
