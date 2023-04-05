package util;

import grafo.CFC;
import grafo.GrafoDirigido;
import grafo.VerticeForte;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CFCUtil<E> {

    private static <E> void preencherPilha(VerticeForte<E> v, Stack<VerticeForte<E>> pilha) {
        v.setVisitado(true);
        v.getSucessores().stream().filter(e -> !e.isVisitado()).forEach(e -> preencherPilha(e, pilha));
        pilha.push(v);
    }

    public static <E> List<CFC<E>> adiquirirCFCs(GrafoDirigido<E> grafo) {
        Stack<VerticeForte<E>> pilha = new Stack<>();
        List<CFC<E>> listaCfcs = new ArrayList<>();

        grafo.getVertices().stream().filter(e -> !e.isVisitado()).forEach(e -> preencherPilha(e, pilha));
        grafo.transpor();
        pilha.forEach(VerticeForte::zerarVisitas);

        while (!pilha.empty()) {
            CFC<E> cfc = new CFC<>();
            VerticeForte<E> v = pilha.pop();
            if (!v.isVisitado()) {
                acumularCfcs(v, cfc);
                listaCfcs.add(cfc);
            }
        }

        return listaCfcs;
    }

    private static <E> void acumularCfcs(VerticeForte<E> v, CFC<E> cfc) {
        v.setVisitado(true);
        cfc.getCluster().add(v);
        v.getSucessores().stream().filter(e -> !e.isVisitado()).forEach(e -> acumularCfcs(e, cfc));
    }

    public static <E> void recomendar(List<CFC<E>> cfcs) {
        for (CFC<E> cfcDaVez : cfcs) {
            for (VerticeForte<E> vOut : cfcDaVez.getCluster()) {
                if (cfcDaVez.getCluster().size() > 1) {
                    for (VerticeForte<E> vIn : vOut.getSucessores()) {
                        if (!vIn.getSucessores().contains(vOut)) recomendar(vOut, vIn);
                    }
                }
            }
        }
    }

    private static <E> void recomendar(VerticeForte<E> vOut, VerticeForte<E> vIn) {
        System.out.println("O vértice " + vOut.getRotulo() + " deveria seguir o vértice " + vIn.getRotulo());
    }

}