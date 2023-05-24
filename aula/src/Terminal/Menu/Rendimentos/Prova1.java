package Terminal.Menu.Rendimentos;

import java.util.Scanner;

import Exception.TodasExcecoes;
import Fabricas.FabricaCadastroCursoAluno;
import aula.cadastro.CadastroCursoAluno;

public class Prova1 extends RendimentosControle {
	
	public Prova1() {
		super();
	}
	
	@Override
	public Prova1 executar(CadastroCursoAluno cursoAluno, Scanner scan, FabricaCadastroCursoAluno fcca) throws  TodasExcecoes {
		super.executar(cursoAluno, scan, fcca);
		return this;
	}
	
	@Override
	public double getValor(CadastroCursoAluno cursoAluno) {
		return cursoAluno.getRendimento().getNp1();
	}
	
	@Override
	public void setRendimentoTipo(CadastroCursoAluno cursoAluno,Double valor) {
		cursoAluno.getRendimento().setNp1(valor);
	}

}
