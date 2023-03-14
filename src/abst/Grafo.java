package abst;

import grafo.Vertice;

import java.util.ArrayList;
import java.util.List;

public abstract class Grafo<T> {

	protected List<Vertice<T>> vertices;

	public Grafo() {
		this.vertices = new ArrayList<>();
	}

	public void adicionarVertice(Vertice<T> vertice) {
		this.vertices.add(vertice);
	}

	public void adicionarVertice(Vertice<T>... vertice) {
		this.vertices.addAll(List.of(vertice));
	}

	public abstract boolean verificaCiclo();

	public List<Vertice<T>> getVertices() {
		return this.vertices;
	}

}
