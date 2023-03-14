package grafo;

import abst.Grafo;
import util.GrafoUtil;

public class GrafoListAdj<T> extends Grafo<T> {

	@Override
	public boolean verificaCiclo() {
		int[][] matriz = GrafoUtil.construirMatriz(this);
		GrafoUtil.imprimirMatrizAdjacencia(matriz, this);
		vertices.get(0).setVisitado(true);
		return verificaCiclo(vertices.get(0));
	}

	private boolean verificaCiclo(Vertice<T> a) {
		for (Vertice<T> vizinho : a.getVerticesConectados()) {
			if (vizinho.isVisitado()) {
				return true;
			}
			vizinho.setVisitado(true);
			return verificaCiclo(vizinho);
		}
		return false;
	}

}
