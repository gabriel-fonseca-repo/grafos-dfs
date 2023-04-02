package main;

import grafo.Grafo;
import grafo.VerticeForte;
import util.CFCUtil;

public class MainCFC {
    public static void main(String[] args) {

        Grafo<VerticeForte<String>, String> grafo = new Grafo<>();

        VerticeForte<String> v0 = new VerticeForte<>("0", "Vertice 0");
        VerticeForte<String> v1 = new VerticeForte<>("1", "Vertice 1");
        VerticeForte<String> v2 = new VerticeForte<>("2", "Vertice 2");
        VerticeForte<String> v3 = new VerticeForte<>("3", "Vertice 3");
        VerticeForte<String> v4 = new VerticeForte<>("4", "Vertice 4");

        v1.adicionarSucessor(v0);
        v0.adicionarSucessor(v2);
        v2.adicionarSucessor(v1);
        v0.adicionarSucessor(v3);
        v3.adicionarSucessor(v4);

        grafo.adicionarVertice(v0, v1, v2, v3, v4);
        CFCUtil<String> cfcUtil = new CFCUtil<>(grafo);
        cfcUtil.printarCFCs();
    }
}
