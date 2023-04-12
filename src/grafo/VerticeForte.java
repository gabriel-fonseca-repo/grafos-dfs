package grafo;

import java.util.ArrayList;
import java.util.List;

public class VerticeForte<E> extends Vertice<E> {

    private List<VerticeForte<E>> sucessores;
    private List<VerticeForte<E>> predecessores;

    private boolean transposto;

    public void adicionarSucessor(VerticeForte<E> sucessorIn) {
        this.sucessores.add(sucessorIn);
        if (!sucessorIn.getPredecessores().contains(this)) {
            sucessorIn.adicionarPredecessor(this);
        }
    }

    public void adicionarPredecessor(VerticeForte<E> predecessorIn) {
        this.predecessores.add(predecessorIn);
        if (!predecessorIn.getSucessores().contains(this)) {
            predecessorIn.getSucessores().add(this);
        }
    }

    @SafeVarargs
    public final void adicionarSucessor(VerticeForte<E>... sucessoresIn) {
        for (VerticeForte<E> a : sucessoresIn) {
            adicionarSucessor(a);
        }
    }

    @SafeVarargs
    public final void adicionarPredecessor(VerticeForte<E>... predecessoresIn) {
        for (VerticeForte<E> a : predecessoresIn) {
            adicionarPredecessor(a);
        }
    }

    @Override
    public List<Vertice<E>> getVerticesConectados() {
        return (List<Vertice<E>>) (List<?>) this.sucessores;
    }

    public VerticeForte(E elemento) {
        super(elemento);
        this.sucessores = new ArrayList<>();
        this.predecessores = new ArrayList<>();
    }

    public VerticeForte(String rotulo, E elemento) {
        super(rotulo, elemento);
        this.sucessores = new ArrayList<>();
        this.predecessores = new ArrayList<>();
    }

    public List<VerticeForte<E>> getSucessores() {
        return sucessores;
    }

    public List<VerticeForte<E>> getPredecessores() {
        return predecessores;
    }

    public void setSucessores(List<VerticeForte<E>> sucessores) {
        this.sucessores = sucessores;
    }

    public void setPredecessores(List<VerticeForte<E>> predecessores) {
        this.predecessores = predecessores;
    }

    public void setTransposto(boolean transposto) {
        this.transposto = transposto;
    }

    public boolean isTransposto() {
        return transposto;
    }

    public void zerarVisitas() {
        setVisitado(false);
        getSucessores().stream().filter(Vertice::isVisitado).forEach(VerticeForte::zerarVisitas);
        getPredecessores().stream().filter(Vertice::isVisitado).forEach(VerticeForte::zerarVisitas);
    }

    public void inverterVertice() {
        transposto = !transposto;
        List<VerticeForte<E>> aux = sucessores;
        sucessores = predecessores;
        predecessores = aux;
    }
}