package util;

import grafo.Grafo;
import grafo.VerticeForte;

import java.util.Stack;

public class CFCUtil<E> {

    private static <E> Grafo<VerticeForte<E>, E> transporGrafo(Grafo<VerticeForte<E>, E> grafo) {
        Grafo<VerticeForte<E>, E> g = new Grafo<>();
        grafo.getVertices().forEach(e -> {
            e.inverterVertice();
            g.adicionarVertice(e);
        });
        return g;
    }

    private static <E> void preencherPilha(VerticeForte<E> v, Stack<VerticeForte<E>> pilha) {
        v.setVisitado(true);
        for (VerticeForte<E> n : v.getSucessores()) {
            if (!n.isVisitado()) {
                preencherPilha(n, pilha);
            }
        }
        pilha.push(v);
    }

    public static <E> void printarCFCs(Grafo<VerticeForte<E>, E> grafo) {
        Stack<VerticeForte<E>> pilha = new Stack<>();
        grafo.getVertices().stream().filter(e -> !e.isVisitado()).forEach(e -> preencherPilha(e, pilha));
        Grafo<VerticeForte<E>, E> grafoTransposto = transporGrafo(grafo);
        grafoTransposto.getVertices().forEach(e -> e.setVisitado(false));
        pilha.forEach(e -> e.setVisitado(false));
        while (!pilha.empty()) {
            VerticeForte<E> verticeForte = pilha.pop();
            if (!verticeForte.isVisitado()) {
                DFSUtil(verticeForte);
                System.out.println();
            }
        }
    }

    private static <E> void DFSUtil(VerticeForte<E> v) {
        v.setVisitado(true);
        System.out.print(v.getRotulo() + " ");

        for (VerticeForte<E> e : v.getSucessores()) {
            if (!e.isVisitado())
                DFSUtil(e);
        }
    }

}