package Terminal.Menu.TodosMenus;

import java.util.Scanner;

import Fabricas.FabricaDeCurso;
import Terminal.Menu.Menus;



public class ListarMaterias extends Menus {

	public ListarMaterias(Scanner scan,Integer id) {
		super(scan, id);

	}

	@Override
	public void executar() {
		FabricaDeCurso fabricaDeCurso = new FabricaDeCurso();
		fabricaDeCurso.resultadoGeral();
	}
}
