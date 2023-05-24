package Terminal.Menu.TodosMenus;

import java.util.Scanner;

import Exception.EntradaDeNumeroInserindoLetraException;
import Fabricas.FabricaCadastroCursoAluno;
import Fabricas.FabricaDeAluno;
import Fabricas.FabricaDeCurso;
import Terminal.Menu.Menus;
import Verificacoes.EntradaDeNumeroInserindoLetra;
import aula.cadastro.Aluno;
import aula.cadastro.Curso;

public class CadastrarCursoNoAlunoEscolhido extends Menus {

	public CadastrarCursoNoAlunoEscolhido(Scanner scan, Integer id) {
		super(scan, id);
	}

	@Override
	public void executar() throws NumberFormatException, EntradaDeNumeroInserindoLetraException {
		FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
		FabricaDeCurso fabricaDeCurso = new FabricaDeCurso();
		fabricaDeAluno.resultadoGeral();
		System.out.println("Digite o ID do Aluno que deseja cadastrar...");
		String idAluno = scan.next();
		if (new EntradaDeNumeroInserindoLetra().verificar(idAluno)) {
			fabricaDeCurso.resultadoGeral();
			System.out.println("Digite o ID do Curso que deseja cadastrar...");
			String cursoId = scan.next();
			
			if (new EntradaDeNumeroInserindoLetra().verificar(cursoId)) {
				if (Integer.parseInt(cursoId) >= 0 && Integer.parseInt(cursoId) <= fabricaDeCurso.buscaPorTodos().size()) {
					if (Integer.parseInt(idAluno) >= 0 && Integer.parseInt(idAluno) < fabricaDeAluno.buscaPorTodos().size()) {
						Aluno aluno = fabricaDeAluno.buscarPorId(idAluno);
						Curso curso = fabricaDeCurso.buscarPorId(cursoId);
						new FabricaCadastroCursoAluno().gerar(aluno, curso);
						System.out.println("Aluno: " + aluno.getNome() + " Curso: "	+ curso.getNome() + " MATRICULADO com SUCESSO !!");
						new GeradorCSV(scan).gravarCsvApartirDosMapsDoMomento();
					}
				}
			}
		}

	}
}
