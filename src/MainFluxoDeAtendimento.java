import abst.Grafo;
import grafo.GrafoMatrAdj;
import grafo.Vertice;

public class MainFluxoDeAtendimento {

	public static Grafo<String> grafo;

	public static void main(String[] args) {
		criarGrafoFluxo();
		dizSeTemCiclo(grafo);
	}

	private static void dizSeTemCiclo(Grafo<?> grafo) {
		if (grafo.verificaCiclo()) {
			System.out.println("Existe um ciclo\n");
		} else {
			System.out.println("Não existe um ciclo\n");
		}
	}

	public static void criarGrafoFluxo() {

		Vertice<String> A = new Vertice<>("A", "Recepção");
		Vertice<String> B = new Vertice<>("B", "Consulta");
		Vertice<String> C = new Vertice<>("C", "Emergência");
		Vertice<String> D = new Vertice<>("D", "Consultório");
		Vertice<String> E = new Vertice<>("E", "Recepção Imagem");
		Vertice<String> F = new Vertice<>("F", "Enfermaria");
		Vertice<String> G = new Vertice<>("G", "UTI");
		Vertice<String> H = new Vertice<>("H", "Centro cirurgico");

		A.adicionarConectado(B, C);
		B.adicionarConectado(D, E);
		C.adicionarConectado(E, F);
		D.adicionarConectado(A, E);
		E.adicionarConectado(D, F);
		F.adicionarConectado(H, G, E, A);
		G.adicionarConectado(F, H);
		H.adicionarConectado(F, G);

		grafo = new GrafoMatrAdj<>();
		grafo.adicionarVertice(A, B, C, D, E, F, G, H);

	}
}
