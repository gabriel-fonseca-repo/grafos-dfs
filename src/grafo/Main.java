package grafo;

public class Main {
    public static Grafo<String> grafo;

    public static void main(String[] args) {
        criarGrafo1();
        dizSeTemCiclo(grafo);

        criarGrafo2();
        dizSeTemCiclo(grafo);
    }

    private static void dizSeTemCiclo(Grafo<String> grafo) {
        if (grafo.verificaCiclo()) {
            System.out.println("Existe um ciclo\n");
        } else {
            System.out.println("Não existe um ciclo\n");
        }
    }

    public static void criarGrafo1() {
        Vertice<String> A = new Vertice<String>("A");
        Vertice<String> B = new Vertice<String>("B");
        Vertice<String> C = new Vertice<String>("C");

        A.adicionarConectado(C);
        B.adicionarConectado(A);
        C.adicionarConectado(B);

        grafo = new Grafo<>();
        grafo.adicionarVertice(A);
        grafo.adicionarVertice(B);
        grafo.adicionarVertice(C);
    }

    public static void criarGrafo2() {
        Vertice<String> A = new Vertice<String>("A");
        Vertice<String> B = new Vertice<String>("B");
        Vertice<String> C = new Vertice<String>("C");
        Vertice<String> D = new Vertice<String>("D");

        A.adicionarConectado(B);
        B.adicionarConectado(C);
        C.adicionarConectado(D);
        //A.adicionarConectado(A);
        //D.adicionarConectado(A);

        grafo = new Grafo<>();
        grafo.adicionarVertice(A);
        grafo.adicionarVertice(B);
        grafo.adicionarVertice(C);
        grafo.adicionarVertice(D);
    }
}