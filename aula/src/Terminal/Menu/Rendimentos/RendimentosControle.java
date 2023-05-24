package Terminal.Menu.Rendimentos;

import java.util.List;
import java.util.Scanner;

import Exception.VerificaSeSimOuNaoException;
import Exception.VerificarSeDoubleException;
import Fabricas.FabricaCadastroCursoAluno;
import Terminal.CONTROLEGERAL;
import Verificacoes.VerificaSeSimOuNao;
import Verificacoes.VerificarSeDouble;
import aula.cadastro.CadastroCursoAluno;

public class RendimentosControle {

	public RendimentosControle() {
	}

	public RendimentosControle executar(CadastroCursoAluno cursoAluno, Scanner scan, FabricaCadastroCursoAluno fcca) throws VerificarSeDoubleException, VerificaSeSimOuNaoException
		 {
		String[] nome = this.toString().split("\\.");
		String correto = nome[0];

		System.out.println(
				"Nota da " + correto + " esta " + this.getValor(cursoAluno) + " deseja alterar para qual valor ?");
		String novaReposicao = scan.next();
		if (new VerificarSeDouble().verificar(novaReposicao)) {
			System.out.println("Deseja alterar para " + novaReposicao + " ? [s]/[n]");
			String resposta = scan.next().toLowerCase();

			if (new VerificaSeSimOuNao().verificar(resposta)) {
				this.setRendimentoTipo(cursoAluno, Double.parseDouble(novaReposicao));
				List<CadastroCursoAluno> list = CONTROLEGERAL.transformaMapEmListCadastroCursoAluno();
				for (CadastroCursoAluno cada : list) {
					if (cada.getId().equals(cursoAluno.getId())) {
						cada = cursoAluno;
					}
				}
				System.out.println(correto + " alterado com SUCESSO !!");
				return this;
			}

		}

		return null;
	}

	public double getValor(CadastroCursoAluno cursoAluno) {
		return 0;
	}

	public void setRendimentoTipo(CadastroCursoAluno cursoAluno, Double valor) {

	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
