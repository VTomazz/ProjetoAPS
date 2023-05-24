package Terminal;

import java.util.Map;
import java.util.Scanner;

import Exception.TodasExcecoes;
import Terminal.Menu.Menus;
import Terminal.Menu.TabelaCarregandoTodosOsMenus;
import Verificacoes.EntradaDeNumeroInserindoLetra;

public class Exec {
	// private CONTROLEGERAL cg = new CONTROLEGERAL();

	protected void iniciar() {
		int opcao = 0;
		CONTROLEGERAL.leituraDeMaps();
		Scanner scan = new Scanner(System.in);

		while (opcao != 99) {

			TabelaCarregandoTodosOsMenus tctom = new TabelaCarregandoTodosOsMenus(scan);
			Map<Integer, Menus> todosmenus = tctom.getLista();

			CONTROLEGERAL.transformaMapEmListCadastroCursoAluno().forEach(c -> c.getRendimento().atualizaRendimentoTodos());
			System.out.println("|||||||||||||||||||||| TELA PRINCIPAL");
			System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
			System.out.println("[1]- CADASTRO DE ALUNOS");
			System.out.println("[2]- LISTAR ALUNOS");
			System.out.println("[3]- CADASTRO DE MATERIAS");
			System.out.println("[4]- LISTAR MATERIAS");
			System.out.println("[5]- LISTAR MATERIAS do ANO");
			System.out.println("[6]- INFORMACOES ALUNO");
			System.out.println("[7]- EDITOR ALUNO");
			System.out.println("[8]- CADASTRAR CURSO NO ALUNO");
			System.out.println("[9]- GERAR .CSV");
			System.out.println("[10]- BUSCAR ALUNOS POR CURSO X POR ANO X");
			System.out.println("[99]- FECHAR SISTEMA");
			System.out.println("|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
			System.out.println();
			System.out.println("Digite uma opcão...");
			try {
				String resposta = scan.next();

				if (new EntradaDeNumeroInserindoLetra().verificar(resposta)) {
					opcao = Integer.parseInt(resposta);
	
				}

				if (opcao == 99) {
					break;
				}
				if (opcao != 99 && opcao > 0 && opcao < todosmenus.size() + 1) {
					todosmenus.get(opcao).executar();

				}

			} catch ( TodasExcecoes e) {
				System.out.println("c");
			}

		}
		scan.close();
	}
}
