import grafos.Grafo;
import grafos.No;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>(4);
        grafo.adicionarVertice(new No<>("eita0", 0), new No<>("eita1", 1));
        grafo.adicionarVertice(new No<>("eita0", 0), new No<>("eita2", 2));
        grafo.adicionarVertice(new No<>("eita1", 1), new No<>("eita2", 2));
        grafo.adicionarVertice(new No<>("eita2", 2), new No<>("eita0", 3));
        grafo.adicionarVertice(new No<>("eita2", 2), new No<>("eita3", 3));
        grafo.adicionarVertice(new No<>("eita3", 3), new No<>("eita3", 3));

        if (grafo.ehCiclico()) {
            System.out.println("é cíclico");
        } else {
            System.out.println("não é cíclico");
        }

        Grafo.printarGrafo(new ArrayList<>(grafo.getNos()));


    }
}