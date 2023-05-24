package Terminal.Menu.Rendimentos;

import java.util.Scanner;

import Exception.VerificaSeSimOuNaoException;
import Fabricas.FabricaCadastroCursoAluno;
import Terminal.CONTROLEGERAL;
import Verificacoes.VerificaSeSimOuNao;
import aula.cadastro.CadastroCursoAluno;

public class ExcluirCurso extends RendimentosControle {

	public ExcluirCurso() {
		super();
	}

	@Override
	public ExcluirCurso executar(CadastroCursoAluno cursoAluno, Scanner scan, FabricaCadastroCursoAluno fcca) 
			throws VerificaSeSimOuNaoException {
		System.out.println("Deseja realmente excluir este curso ? [s]/[n]");
		String sOuN = scan.next();

		if (new VerificaSeSimOuNao().verificar(sOuN)) {
			cursoAluno.getAluno().removeCurso(cursoAluno, String.valueOf(cursoAluno.getId()));// RETIRA O CURSO DO ALUNO
			CONTROLEGERAL.MAP_PRINCIPAL_CURSO.remove(cursoAluno.getId());// RETIRA O CURSO DO MAP DE CURSOS
			System.out.println("Curso removido com sucesso !");
		}

		return this;
	}

}
