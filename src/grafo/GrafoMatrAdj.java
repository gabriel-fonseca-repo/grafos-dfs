package grafo;

import abst.Grafo;
import util.GrafoUtil;

public class GrafoMatrAdj<T> extends Grafo<T> {

	private int[][] matriz;

	@Override
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

}