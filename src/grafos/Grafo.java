package grafos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Grafo<T> {

    private ArrayList<No<T>> nos;

    public Grafo(int tamanho) {
        this.nos = new ArrayList<>(tamanho);
        for (int index = 0; index < tamanho; index++) {
            No<T> novoNo = new No<>(null, index);
            novoNo.setListaDeAdjacencia(new LinkedList<>());
            this.nos.add(novoNo);
        }
    }

    public ArrayList<No<T>> getNos() {
        return nos;
    }

    public void setNos(ArrayList<No<T>> nos) {
        this.nos = nos;
    }

    public boolean ehCiclico() {
        try {
            Stack<No<T>> pilhaDeRecursao = new Stack<>();

            for (No<T> no : nos)
                if (ehCiclicoUtil(no, pilhaDeRecursao))
                    return true;

            return false;
        } finally {
            nos.forEach(e -> e.setVisitado(false));
        }

    }

    private boolean ehCiclicoUtil(No<T> no, Stack<No<T>> pilhaDeRecursao) {
        if (pilhaDeRecursao.contains(no))
            return true;

        if (no.isVisitado())
            return false;

        no.setVisitado(true);
        pilhaDeRecursao.push(no);

        LinkedList<No<T>> nosFilhos = nos.get(no.getIndice()).getListaDeAdjacencia();

        for (No<T> c : nosFilhos)
            if (ehCiclicoUtil(c, pilhaDeRecursao))
                return true;

        pilhaDeRecursao.pop();

        return false;
    }

    public void adicionarVertice(No<T> fonte, No<T> destino) {

        if (fonte.getIndice() != null && estaNoIntervalo(fonte))
            return;

        nos.get(fonte.getIndice()).getListaDeAdjacencia().add(destino);
    }

    private boolean estaNoIntervalo(No<T> fonte) {
        return fonte.getIndice() < 0 || fonte.getIndice() >= nos.size();
    }

    public static void printarGrafo(List<No<?>> nos) {
        for (No<?> no : nos) {
            System.out.print(no.getConteudo() + " -> ");
            if (no.getListaDeAdjacencia() != null && !no.getListaDeAdjacencia().isEmpty()) {
                printarGrafo(new ArrayList<>(no.getListaDeAdjacencia()));
            }
        }
    }
}
