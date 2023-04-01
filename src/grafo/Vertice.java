package grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice<E> {

	private final E elemento;
	private final List<Vertice<E>> verticesConectados;
	private String rotulo;
	private boolean visitado;

	public Vertice(E elemento) {
		this.elemento = elemento;
		this.verticesConectados = new ArrayList<>();
		this.visitado = false;
	}

	public Vertice(String rotulo, E elemento) {
		this.elemento = elemento;
		this.verticesConectados = new ArrayList<>();
		this.visitado = false;
		this.rotulo = rotulo;
	}

	public void adicionarConectado(Vertice<E> conectado) {
		this.verticesConectados.add(conectado);
	}

	@SafeVarargs
	public final void adicionarConectado(Vertice<E>... conectados) {
		this.verticesConectados.addAll(List.of(conectados));
	}

	public List<Vertice<E>> getVerticesConectados() {
		return verticesConectados;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public E getElemento() {
		return elemento;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
}