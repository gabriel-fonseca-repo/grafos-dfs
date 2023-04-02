package main;

import grafo.Grafo;
import grafo.VerticeFraco;

public class MainFluxoDeAtendimento {

    public static Grafo<VerticeFraco<String>, String> grafo;

    public static void main(String[] args) {
        criarGrafoFluxo();
        dizSeTemCiclo(grafo);
    }

    private static void dizSeTemCiclo(Grafo<?, ?> grafo) {
        if (grafo.verificaCiclo()) {
            System.out.println("Existe um ciclo\n");
        } else {
            System.out.println("Não existe um ciclo\n");
        }
    }

    public static void criarGrafoFluxo() {

        VerticeFraco<String> A = new VerticeFraco<>("A", "Recepção");
        VerticeFraco<String> B = new VerticeFraco<>("B", "Consulta");
        VerticeFraco<String> C = new VerticeFraco<>("C", "Emergência");
        VerticeFraco<String> D = new VerticeFraco<>("D", "Consultório");
        VerticeFraco<String> E = new VerticeFraco<>("E", "Recepção Imagem");
        VerticeFraco<String> F = new VerticeFraco<>("F", "Enfermaria");
        VerticeFraco<String> G = new VerticeFraco<>("G", "UTI");
        VerticeFraco<String> H = new VerticeFraco<>("H", "Centro cirurgico");

        A.adicionarConectado(B, C);
        B.adicionarConectado(D, E);
        C.adicionarConectado(E, F);
        D.adicionarConectado(A, E);
        E.adicionarConectado(D, F);
        F.adicionarConectado(H, G, E, A);
        G.adicionarConectado(F, H);
        H.adicionarConectado(F, G);

        grafo = new Grafo<>();
        grafo.adicionarVertice(A, B, C, D, E, F, G, H);

    }
}
