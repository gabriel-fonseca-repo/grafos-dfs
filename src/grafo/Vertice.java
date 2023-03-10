package grafo;

import java.util.ArrayList;
import java.util.List;

public class Vertice<E> {

    private final E elemento;

    private final List<Vertice<E>> verticesConectados;

    private boolean visitado;

    public Vertice(E elemento) {
        this.elemento = elemento;
        this.verticesConectados = new ArrayList<>();
        this.visitado = false;
    }

    public void adicionarConectado(Vertice<E> conectado) {
        this.verticesConectados.add(conectado);
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
}