package Terminal.Menu.Rendimentos;

import java.util.Scanner;

import Exception.TodasExcecoes;
import Fabricas.FabricaCadastroCursoAluno;
import aula.cadastro.CadastroCursoAluno;

public class Exame extends RendimentosControle {
	
	public Exame() {
		super();
	}
	
	@Override
	public Exame executar(CadastroCursoAluno cursoAluno, Scanner scan, FabricaCadastroCursoAluno fcca) throws TodasExcecoes {
		super.executar(cursoAluno, scan, fcca);
		return this;
		
	}
	
	@Override
	public double getValor(CadastroCursoAluno cursoAluno) {
		return cursoAluno.getRendimento().getExame();
	}
	
	@Override
	public void setRendimentoTipo(CadastroCursoAluno cursoAluno, Double valor) {
		cursoAluno.getRendimento().setExame(valor);
	}

}
