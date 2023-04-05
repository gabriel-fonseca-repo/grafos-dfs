package grafo;

import java.util.ArrayList;
import java.util.List;

public class VerticeFraco<E> extends Vertice<E> {

    private final List<VerticeFraco<E>> verticesConectados;

    public VerticeFraco(E elemento) {
        super(elemento);
        this.verticesConectados = new ArrayList<>();
    }

    public VerticeFraco(String rotulo, E elemento) {
        super(rotulo, elemento);
        this.verticesConectados = new ArrayList<>();
    }

    public void adicionarConectado(VerticeFraco<E> conectado) {
        this.verticesConectados.add(conectado);
    }

    @SafeVarargs
    public final void adicionarConectado(VerticeFraco<E>... conectados) {
        this.verticesConectados.addAll(List.of(conectados));
    }

    public List<Vertice<E>> getVerticesConectados() {
        return (List<Vertice<E>>) (List<?>) verticesConectados;
    }

}