import abst.Grafo;
import grafo.GrafoMatrAdj;
import grafo.Vertice;

public class MainArvoreDeDecisao {

	public static Grafo<String> grafo;

	public static void main(String[] args) {
		criarGrafoArvore();
		dizSeTemCiclo(grafo);
	}

	private static void dizSeTemCiclo(Grafo<?> grafo) {
		if (grafo.verificaCiclo()) {
			System.err.println("Existe um ciclo na árvore de decisão\n");
		} else {
			System.out.println("Não existe um ciclo\n");
		}
	}

	public static void criarGrafoArvore() {

		Vertice<String> A = new Vertice<>("A", "Paciente maior de idade na APS");
		Vertice<String> B = new Vertice<>("B", "Verificar PA (duas verificações)");
		Vertice<String> C = new Vertice<>("C", "PA < 120/80 mmHg");
		Vertice<String> D = new Vertice<>("D", "Orientar prevenção primária e reavaliar em 2 anos");
		Vertice<String> E = new Vertice<>("E", "120/80 <= PA < 140/90 mmHg");
		Vertice<String> F = new Vertice<>("F", "120/80 <= PA < 130/85 mmHg");
		Vertice<String> G = new Vertice<>("G", "Orientar prevenção primária e reavaliar em 1 ano");
		Vertice<String> H = new Vertice<>("H", "135/85 <= PA < 140/90 mmHg");
		Vertice<String> I = new Vertice<>("I", "Consulta de enfermagem para MEV e estratificação da RCV");
		Vertice<String> J = new Vertice<>("J", "PA >= 140/80 mmHg");
		Vertice<String> K = new Vertice<>("K", "140/90 <= PA < 160/100 mmHg");
		Vertice<String> L = new Vertice<>("L", "Consulta de enfermagem para MEV e estratificação da RCV");
		Vertice<String> M = new Vertice<>("M", "PA >= 160/90 mmHg");
		Vertice<String> N = new Vertice<>("N", "Consulta médica");

		A.adicionarConectado(B);
		B.adicionarConectado(C, E, J);
		C.adicionarConectado(D);
		E.adicionarConectado(F, H);
		F.adicionarConectado(G);
		H.adicionarConectado(I);
		J.adicionarConectado(K, M);
		K.adicionarConectado(L);
		M.adicionarConectado(N);

		grafo = new GrafoMatrAdj<>();
		grafo.adicionarVertice(A, B, C, D, E, F, G, H, I, J, K, L, M, N);

	}
}
