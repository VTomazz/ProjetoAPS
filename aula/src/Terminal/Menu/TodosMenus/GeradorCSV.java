package Terminal.Menu.TodosMenus;

import java.util.Scanner;

import GeradorCSV.AlunoCSV;
import GeradorCSV.CadastroCursoAlunoCSV;
import GeradorCSV.CursoCSV;
import Terminal.Menu.Menus;

public class GeradorCSV extends Menus {

	public GeradorCSV(Scanner scan) {
		super(scan);
		gravarCsvApartirDosMapsDoMomento();
	}

	public void gravarCsvApartirDosMapsDoMomento() {
		new AlunoCSV().gravar();
		new CursoCSV().gravar();
		new CadastroCursoAlunoCSV().gravar();

		System.out.println("Gravacao dos dados e .csv...");

	}

}
