package grafos;

import java.util.ArrayList;
import java.util.LinkedList;

public class No<T> {

    private Integer indice;

    private LinkedList<No<T>> listaDeAdjacencia;

    private T conteudo;

    private boolean visitado;

    public No(T conteudo, Integer indice) {
        this.conteudo = conteudo;
        this.indice = indice;
    }

    public LinkedList<No<T>> getListaDeAdjacencia() {
        return listaDeAdjacencia;
    }

    public void setListaDeAdjacencia(LinkedList<No<T>> listaDeAdjacencia) {
        this.listaDeAdjacencia = listaDeAdjacencia;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }
}
