package Terminal.Menu.TodosMenus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.EntradaDeNumeroInserindoLetraException;
import Exception.ValorDoAnoException;
import Terminal.CONTROLEGERAL;
import Terminal.Menu.Menus;
import Verificacoes.EntradaDeNumeroInserindoLetra;
import Verificacoes.VerificarDataCorreta;
import aula.cadastro.Curso;

public class ListarMateriasPeloAnoX extends Menus {

	public ListarMateriasPeloAnoX(Scanner scan, Integer id) {
		super(scan, id);
	}

	@Override
	public void executar() throws EntradaDeNumeroInserindoLetraException, ValorDoAnoException {
		System.out.println("Digite o ano que deseja buscar...");
		String ano = scan.next();
		if (new EntradaDeNumeroInserindoLetra().verificar(ano)) {
			if (new VerificarDataCorreta().verificar(ano)) {
				System.out.println("---------------------------------------------");
				System.out.println("RESULTADO:-----------------------------------");
				List<Curso> list = CONTROLEGERAL.transformaMapEmListCurso();
				List<Curso> resultado = new ArrayList<>();
				for(Curso curso : list) {
					if (String.valueOf(curso.getAno()).equals(ano)) {
						resultado.add(curso);
					}
					
				}
				resultado.forEach(cada -> System.out.println(cada));
				System.out.println("---------------------------------------------");
				System.out.println();
			}
		}
	}
}
