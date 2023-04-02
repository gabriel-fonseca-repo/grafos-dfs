package util;

import grafo.Grafo;
import grafo.VerticeForte;

import java.util.Stack;

public class CFCUtil<E> {

    private final Grafo<VerticeForte<E>, E> grafo;
    private final Stack<VerticeForte<E>> pilha;

    public CFCUtil(Grafo<VerticeForte<E>, E> grafo) {
        this.grafo = grafo;
        this.pilha = new Stack<>();
    }

    public CFCUtil(Grafo<VerticeForte<E>, E> grafo, Stack<VerticeForte<E>> pilha) {
        this.grafo = grafo;
        this.pilha = pilha;
    }

    private Grafo<VerticeForte<E>, E> transporGrafo() {
        Grafo<VerticeForte<E>, E> g = new Grafo<>();
        grafo.getVertices().forEach(e -> {
            e.inverterVertice();
            g.adicionarVertice(e);
        });
        return g;
    }

    private void preencherPilha(VerticeForte<E> v) {
        v.setVisitado(true);
        for (VerticeForte<E> n : v.getSucessores()) {
            if (!n.isVisitado()) {
                preencherPilha(n);
            }
        }
        pilha.push(v);
    }

    public void printarCFCs() {
        grafo.getVertices().stream().filter(e -> !e.isVisitado()).forEach(this::preencherPilha);
        Grafo<VerticeForte<E>, E> grafoTranspose = transporGrafo();
        grafoTranspose.getVertices().forEach(e -> e.setVisitado(false));
        pilha.forEach(e -> e.setVisitado(false));
        CFCUtil<E> cfcTranspose = new CFCUtil<>(grafoTranspose, pilha);
        while (!pilha.empty()) {
            VerticeForte<E> verticeForte = pilha.pop();
            if (!verticeForte.isVisitado()) {
                cfcTranspose.DFSUtil(verticeForte);
                System.out.println();
            }
        }
    }

    public void DFSUtil(VerticeForte<E> v) {
        v.setVisitado(true);
        System.out.print(v.getRotulo() + " ");

        for (VerticeForte<E> e : v.getSucessores()) {
            if (!e.isVisitado())
                DFSUtil(e);
        }
    }

}