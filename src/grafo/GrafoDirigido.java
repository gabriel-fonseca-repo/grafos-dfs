package grafo;

public class GrafoDirigido<T> extends Grafo<VerticeForte<T>, T> {

    private boolean transposto;

    public void transpor() {
        transposto = !transposto;
        getVertices().forEach(VerticeForte::inverterVertice);
    }

}
