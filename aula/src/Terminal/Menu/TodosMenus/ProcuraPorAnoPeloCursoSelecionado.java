package Terminal.Menu.TodosMenus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Exception.EntradaDeNumeroInserindoLetraException;
import Fabricas.FabricaDeCurso;
import GeradorCSV.ProcuraPorAnoPeloCursoSelecionadoCSV;
import Terminal.CONTROLEGERAL;
import Terminal.Menu.Menus;
import Verificacoes.EntradaDeNumeroInserindoLetra;
import aula.cadastro.CadastroCursoAluno;

public class ProcuraPorAnoPeloCursoSelecionado extends Menus {

	public ProcuraPorAnoPeloCursoSelecionado(Scanner scan, Integer id) {
		super(scan, id);
	}

	@Override
	public void executar() throws EntradaDeNumeroInserindoLetraException {
		System.out.println("Digite o ano que deseja busca Alunos que estao cursando...");
		String next = scan.next();
		if (new EntradaDeNumeroInserindoLetra().verificar(next)) {
			new FabricaDeCurso().resultadoGeral();
			System.out.println("Digite o Curso pelo ID que deseja buscar...");
			String next2 = scan.next();
			if (new EntradaDeNumeroInserindoLetra().verificar(next2)) {

				List<CadastroCursoAluno> list = CONTROLEGERAL.transformaMapEmListCadastroCursoAluno();//LISTA ATUAL COM TODOS OS DADOS
				
				List<CadastroCursoAluno> cursosSelecionados = new ArrayList<>();
				
				List<CadastroCursoAluno> listNovaResultado = new ArrayList<>();
				
				for(CadastroCursoAluno ee : list) {
					if (String.valueOf(ee.getCurso().getId()).equals(next2)) {//PRIMEIRO PEGA OS CADASTROS COM ESTE CURSO
						cursosSelecionados.add(ee);
					}
					
					
				}
			
				for (CadastroCursoAluno cada : cursosSelecionados) {
					if (String.valueOf(cada.getAno()).equals(next)) {//COM OS CURSOS EM MAOS ELE SELECIONA OS QUE POSSUI O ANO QUE PEDIU PARA BUSCAR
						listNovaResultado.add(cada);
					}
				}
				
				listNovaResultado.forEach(cada -> System.out.println(cada));
				new ProcuraPorAnoPeloCursoSelecionadoCSV().gravar(listNovaResultado, next);
				
			}
		}
	}

}
