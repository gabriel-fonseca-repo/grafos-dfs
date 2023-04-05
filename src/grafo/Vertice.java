package grafo;

import java.util.List;

public abstract class Vertice<E> {

    private E elemento;
    private String rotulo;
    private boolean visitado;

    public abstract List<Vertice<E>> getVerticesConectados();

    public Vertice(E elemento) {
        this.elemento = elemento;
        this.visitado = false;
    }

    public Vertice(String rotulo, E elemento) {
        this.elemento = elemento;
        this.rotulo = rotulo;
        this.visitado = false;
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

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return "" + this.rotulo;
    }


}
