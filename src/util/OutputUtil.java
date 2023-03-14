package util;

import abst.Grafo;
import grafo.Vertice;

import java.util.List;

public class OutputUtil {

	public static void imprimirMatrizAdjacencia(int[][] matriz, Grafo<?> grafo) {
		List<? extends Vertice<?>> vertices = grafo.getVertices();
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

	private static void imprimirCabecalhoMatriz(List<? extends Vertice<?>> vertices) {
		System.out.print("  ");
		for (Vertice<?> vertice : vertices) {
			System.out.print((vertice.getRotulo() != null ? vertice.getRotulo() : vertice.getElemento()) + " ");
		}
		System.out.println();
	}
}
