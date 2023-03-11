import abst.Grafo;
import grafo.GrafoMatrAdj;
import grafo.Vertice;

public class MainMatriz {

    public static Grafo<String> grafo;

    public static void main(String[] args) {
        criarGrafo1();
        dizSeTemCiclo(grafo);

        criarGrafo2();
        dizSeTemCiclo(grafo);
    }

    private static void dizSeTemCiclo(Grafo<?> grafo) {
        if (grafo.verificaCiclo()) {
            System.out.println("Existe um ciclo\n");
        } else {
            System.out.println("Não existe um ciclo\n");
        }
    }

    public static void criarGrafo1() {
        Vertice<String> A = new Vertice<>("A");
        Vertice<String> B = new Vertice<>("B");
        Vertice<String> C = new Vertice<>("C");

        A.adicionarConectado(C);
        B.adicionarConectado(A);
        C.adicionarConectado(B);

        grafo = new GrafoMatrAdj<>();
        grafo.adicionarVertice(A);
        grafo.adicionarVertice(B);
        grafo.adicionarVertice(C);
    }

    public static void criarGrafo2() {
        Vertice<String> A = new Vertice<>("A");
        Vertice<String> B = new Vertice<>("B");
        Vertice<String> C = new Vertice<>("C");
        Vertice<String> D = new Vertice<>("D");

        A.adicionarConectado(B);
        B.adicionarConectado(C);
        C.adicionarConectado(D);

        //A.adicionarConectado(A);
        //D.adicionarConectado(B);


        grafo = new GrafoMatrAdj<>();
        grafo.adicionarVertice(A);
        grafo.adicionarVertice(B);
        grafo.adicionarVertice(C);
        grafo.adicionarVertice(D);
    }
}
