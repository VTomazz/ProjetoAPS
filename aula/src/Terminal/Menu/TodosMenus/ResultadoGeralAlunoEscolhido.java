package Terminal.Menu.TodosMenus;

import java.util.Scanner;

import Exception.EntradaDeNumeroInserindoLetraException;
import Fabricas.FabricaCadastroCursoAluno;
import Terminal.Menu.Menus;
import Verificacoes.EntradaDeNumeroInserindoLetra;

public class ResultadoGeralAlunoEscolhido extends Menus {

	public ResultadoGeralAlunoEscolhido(Scanner scan, Integer id) {
		super(scan, id);
	}

	@Override
	public void executar() throws EntradaDeNumeroInserindoLetraException {
		System.out.println("Digite o ID do Aluno que deseja visualizar seus Rendimentos");
		String id = scan.next();
		if (new EntradaDeNumeroInserindoLetra().verificar(id)) {
			new FabricaCadastroCursoAluno().buscaTodosPorId(id);
		}
	}
}
