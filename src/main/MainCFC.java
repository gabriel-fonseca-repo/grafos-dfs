package main;

import grafo.CFC;
import grafo.GrafoDirigido;
import grafo.VerticeForte;
import util.CFCUtil;

import java.util.List;

public class MainCFC {
    public static void main(String[] args) {

        GrafoDirigido<String> grafo = new GrafoDirigido<>();

        preencherGrafo3(grafo);

        List<CFC<String>> cfcs = CFCUtil.adiquirirCFCs(grafo);
        System.out.println("Componentes fortemente conexos: ");
        cfcs.forEach(System.out::println);
        System.out.println();
        CFCUtil.recomendar(cfcs);
    }

    private static void preencherGrafo3(GrafoDirigido<String> grafo) {
        VerticeForte<String> v1 = new VerticeForte<>("1", "Vertice 1");
        VerticeForte<String> v2 = new VerticeForte<>("2", "Vertice 2");
        VerticeForte<String> v3 = new VerticeForte<>("3", "Vertice 3");
        VerticeForte<String> v4 = new VerticeForte<>("4", "Vertice 4");
        VerticeForte<String> v5 = new VerticeForte<>("5", "Vertice 5");
        VerticeForte<String> v6 = new VerticeForte<>("6", "Vertice 6");
        VerticeForte<String> v7 = new VerticeForte<>("7", "Vertice 7");

        v1.adicionarSucessor(v2, v4);
        v2.adicionarSucessor(v4, v5);
        v3.adicionarSucessor(v1);
        v4.adicionarSucessor(v3);
        v5.adicionarSucessor(v6);
        v6.adicionarSucessor(v7);
        v7.adicionarSucessor(v5);

        grafo.adicionarVertice(v1, v2, v3, v4, v5, v6, v7);
    }

    private static void preencherGrafo1(GrafoDirigido<String> grafo) {
        VerticeForte<String> a = new VerticeForte<>("A", "Vertice A");
        VerticeForte<String> b = new VerticeForte<>("B", "Vertice B");
        VerticeForte<String> c = new VerticeForte<>("C", "Vertice C");
        VerticeForte<String> d = new VerticeForte<>("D", "Vertice D");
        VerticeForte<String> e = new VerticeForte<>("E", "Vertice E");
        VerticeForte<String> f = new VerticeForte<>("F", "Vertice F");
        VerticeForte<String> g = new VerticeForte<>("G", "Vertice G");

        a.adicionarSucessor(c, d, e);
        b.adicionarSucessor(e);
        c.adicionarSucessor(f, g);
        d.adicionarSucessor(c, b, e);
        e.adicionarSucessor(g);
        f.adicionarSucessor(d, g);
        g.adicionarSucessor(b);

        grafo.adicionarVertice(a, b, c, d, e, f, g);
    }

    private static void preencherGrafo2(GrafoDirigido<String> grafo) {
        VerticeForte<String> v0 = new VerticeForte<>("0", "Vertice 0");
        VerticeForte<String> v1 = new VerticeForte<>("1", "Vertice 1");
        VerticeForte<String> v2 = new VerticeForte<>("2", "Vertice 2");
        VerticeForte<String> v3 = new VerticeForte<>("3", "Vertice 3");
        VerticeForte<String> v4 = new VerticeForte<>("4", "Vertice 4");
        VerticeForte<String> v5 = new VerticeForte<>("5", "Vertice 5");

        v0.adicionarSucessor(v1);
        v1.adicionarSucessor(v2);
        v1.adicionarSucessor(v4);
        v2.adicionarSucessor(v0);
        v2.adicionarSucessor(v3);
        v3.adicionarSucessor(v5);
        v4.adicionarSucessor(v5);

        grafo.adicionarVertice(v0, v1, v2, v3, v4, v5);
    }
}
