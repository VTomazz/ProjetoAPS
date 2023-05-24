package Terminal.Menu.Rendimentos;

import java.util.Scanner;

import Exception.VerificaSeSimOuNaoException;
import Exception.VerificarSeDoubleException;
import Fabricas.FabricaCadastroCursoAluno;
import aula.cadastro.CadastroCursoAluno;

public class Prova2 extends RendimentosControle {
	
	public Prova2() {
		super();
	}
	
	@Override
	public Prova2 executar(CadastroCursoAluno cursoAluno, Scanner scan, FabricaCadastroCursoAluno fcca)
			throws VerificarSeDoubleException, NumberFormatException, VerificaSeSimOuNaoException {
		super.executar(cursoAluno, scan, fcca);
		return this;
	}
	
	@Override
	public double getValor(CadastroCursoAluno cursoAluno) {
		return cursoAluno.getRendimento().getNp2();
	}

	@Override
	public void setRendimentoTipo(CadastroCursoAluno cursoAluno,Double valor) {
		cursoAluno.getRendimento().setNp2(valor);
	}

}
