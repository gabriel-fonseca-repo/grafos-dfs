package main;

import grafo.Grafo;
import grafo.VerticeFraco;

public class MainArvoreDeDecisao {

    public static Grafo<VerticeFraco<String>, String> grafo;

    public static void main(String[] args) {
        criarGrafoArvore();
        dizSeTemCiclo(grafo);
    }

    private static void dizSeTemCiclo(Grafo<?, ?> grafo) {
        if (grafo.verificaCiclo()) {
            System.err.println("Existe um ciclo na árvore de decisão\n");
        } else {
            System.out.println("Não existe um ciclo\n");
        }
    }

    public static void criarGrafoArvore() {

        VerticeFraco<String> A = new VerticeFraco<>("A", "Paciente maior de idade na APS");
        VerticeFraco<String> B = new VerticeFraco<>("B", "Verificar PA (duas verificações)");
        VerticeFraco<String> C = new VerticeFraco<>("C", "PA < 120/80 mmHg");
        VerticeFraco<String> D = new VerticeFraco<>("D", "Orientar prevenção primária e reavaliar em 2 anos");
        VerticeFraco<String> E = new VerticeFraco<>("E", "120/80 <= PA < 140/90 mmHg");
        VerticeFraco<String> F = new VerticeFraco<>("F", "120/80 <= PA < 130/85 mmHg");
        VerticeFraco<String> G = new VerticeFraco<>("G", "Orientar prevenção primária e reavaliar em 1 ano");
        VerticeFraco<String> H = new VerticeFraco<>("H", "135/85 <= PA < 140/90 mmHg");
        VerticeFraco<String> I = new VerticeFraco<>("I", "Consulta de enfermagem para MEV e estratificação da RCV");
        VerticeFraco<String> J = new VerticeFraco<>("J", "PA >= 140/80 mmHg");
        VerticeFraco<String> K = new VerticeFraco<>("K", "140/90 <= PA < 160/100 mmHg");
        VerticeFraco<String> L = new VerticeFraco<>("L", "Consulta de enfermagem para MEV e estratificação da RCV");
        VerticeFraco<String> M = new VerticeFraco<>("M", "PA >= 160/90 mmHg");
        VerticeFraco<String> N = new VerticeFraco<>("N", "Consulta médica");

        A.adicionarConectado(B);
        B.adicionarConectado(C, E, J);
        C.adicionarConectado(D);
        E.adicionarConectado(F, H);
        F.adicionarConectado(G);
        H.adicionarConectado(I);
        J.adicionarConectado(K, M);
        K.adicionarConectado(L);
        M.adicionarConectado(N);

        grafo = new Grafo<>();
        grafo.adicionarVertice(A, B, C, D, E, F, G, H, I, J, K, L, M, N);

    }
}
