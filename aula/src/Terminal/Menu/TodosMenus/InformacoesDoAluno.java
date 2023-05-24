package Terminal.Menu.TodosMenus;

import java.util.Scanner;

import Exception.EntradaDeNumeroInserindoLetraException;
import Fabricas.FabricaCadastroCursoAluno;
import Fabricas.FabricaDeAluno;
import Terminal.Menu.Menus;
import Verificacoes.EntradaDeNumeroInserindoLetra;

public class InformacoesDoAluno extends Menus {

	public InformacoesDoAluno(Scanner scan, Integer id) {
		super(scan, id);
	}

	@Override
	public void executar() throws EntradaDeNumeroInserindoLetraException {

		FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
		fabricaDeAluno.resultadoGeral();
		System.out.println("Digite o ID do aluno que deseja procurar");
		String id = scan.next();
		if (new EntradaDeNumeroInserindoLetra().verificar(id)) {
			System.out.println("---------------------------------------------");
			System.out.println("RESULTADO:-----------------------------------");
			if (!id.isBlank() | id != null | !id.isEmpty())
				new FabricaCadastroCursoAluno().buscaTodosPorId(id);
			System.out.println("---------------------------------------------");
			System.out.println();
		}

	}

}
