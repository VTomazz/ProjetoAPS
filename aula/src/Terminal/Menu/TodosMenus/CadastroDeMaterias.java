package Terminal.Menu.TodosMenus;

import java.util.Scanner;

import Exception.EntradaDeNumeroInserindoLetraException;
import Exception.ValorDoAnoException;
import Fabricas.FabricaDeCurso;
import Terminal.Menu.Menus;
import Verificacoes.EntradaDeLetraInserindoCaracteresEspeciais;
import Verificacoes.EntradaDeNumeroInserindoLetra;
import Verificacoes.VerificarDataCorreta;
import aula.cadastro.NivelGraduacao;

public class CadastroDeMaterias extends Menus {

	public CadastroDeMaterias(Scanner scan, Integer id) {
		super(scan, id);

	}

	@Override
	public void executar() throws EntradaDeNumeroInserindoLetraException, ValorDoAnoException {
		EntradaDeLetraInserindoCaracteresEspeciais verificadorLetra = new EntradaDeLetraInserindoCaracteresEspeciais();
		EntradaDeNumeroInserindoLetra verificadorInteiro = new EntradaDeNumeroInserindoLetra();

		System.out.printf("Digite nome da materia porfavor...");
		scan.nextLine();
		String nomeMateria = scan.nextLine();

		if (verificadorLetra.verificar(nomeMateria)) {
			System.out.printf("Digite o nivel da graduacao... [0]GRADUACAO | [1]POS-GRADUACAO");
			String intGraduacao = scan.next();

			if (verificadorInteiro.verificar(intGraduacao)) {
				if (Integer.parseInt(intGraduacao) == 1 || Integer.parseInt(intGraduacao) == 0) {
					NivelGraduacao[] values = NivelGraduacao.values();
					NivelGraduacao nivel = values[Integer.parseInt(intGraduacao)];
					System.out.printf("Digite o ano de criacao da materia...");
					String ano = scan.next();
					if (verificadorInteiro.verificar(ano)) {
						if (new VerificarDataCorreta().verificar(ano)) {
							new FabricaDeCurso().gerarNovo(nomeMateria, nivel, ano);
							System.out.println("Materia criada com sucesso !!");
							new GeradorCSV(scan).gravarCsvApartirDosMapsDoMomento();
						}

					}
				}

			}

		}

	}

}
