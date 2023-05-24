package Terminal.Menu.TodosMenus;

import java.util.Scanner;

import Exception.EntradaDeNumeroInserindoLetraException;
import Fabricas.FabricaDeAluno;
import Terminal.Menu.Menus;
import Verificacoes.EntradaDeLetraInserindoCaracteresEspeciais;

public class CadastroDeAlunos extends Menus {

	public CadastroDeAlunos(Scanner scan, Integer id) {
		super(scan, id);

	}

	@Override
	public void executar() throws EntradaDeNumeroInserindoLetraException {

		System.out.printf("Digite nome do aluno porfavor...");
		scan.nextLine();
		String nome = scan.nextLine();
		
		
		if (new EntradaDeLetraInserindoCaracteresEspeciais().verificar(nome)) {
			//scan.nextLine();
			new FabricaDeAluno().gerarNovo(nome);
			new GeradorCSV(scan).gravarCsvApartirDosMapsDoMomento();
		}

	}

}
