package Terminal.Menu.Rendimentos;

import java.util.Scanner;

import Exception.VerificaSeSimOuNaoException;
import Exception.VerificarSeDoubleException;
import Fabricas.FabricaCadastroCursoAluno;
import aula.cadastro.CadastroCursoAluno;

public class Reposicao extends RendimentosControle {
	
	public Reposicao() {
		super();
	}
	
	@Override
	public Reposicao executar(CadastroCursoAluno cursoAluno, Scanner scan, FabricaCadastroCursoAluno fcca) throws VerificarSeDoubleException, NumberFormatException, VerificaSeSimOuNaoException {
		super.executar(cursoAluno, scan, fcca);
		return this;
	}
	
	@Override
	public double getValor(CadastroCursoAluno cursoAluno) {
		return cursoAluno.getRendimento().getReposicao();
	}
	
	@Override
	public void setRendimentoTipo(CadastroCursoAluno cursoAluno,Double valor) {
		cursoAluno.getRendimento().setReposicao(valor);
	}


}
