package Terminal.Menu.TodosMenus;

import java.util.Scanner;

import Fabricas.FabricaDeAluno;
import Terminal.Menu.Menus;

public class ListarAlunos extends Menus {

	public ListarAlunos(Scanner scan, Integer id) {
		super(scan, id);
	}

	@Override
	public void executar() {
		FabricaDeAluno fabricaDeAlunos = new FabricaDeAluno();
		fabricaDeAlunos.resultadoGeral();

	}

}
