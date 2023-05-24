package Fabricas;

import java.util.List;

import Terminal.CONTROLEGERAL;
import aula.cadastro.Aluno;

public class FabricaDeAluno {

	public FabricaDeAluno() {

	}

	public void gerarNovo(String nome) {
		Aluno aluno = new Aluno(nome);
		CONTROLEGERAL.MAP_PRINCIPAL_ALUNO.put(aluno.getId(), aluno);
		System.out.println("Aluno criado com sucesso");
	}

	public Aluno buscarPorId(String id) {
		try {
			Aluno aluno = CONTROLEGERAL.MAP_PRINCIPAL_ALUNO.get(Integer.parseInt(id));
			return aluno;
		} catch (NullPointerException e) {
			System.out.println("Aluno não encontrado");
		}
		return null;

	}

	public List<Aluno> buscaPorTodos() {
		return CONTROLEGERAL.transformaMapEmListAluno();
	}

//	public void atualizar(Aluno aluno) {
//		CONTROLEGERAL.
//	}

	public void resultadoGeral() {
		System.out.println("------------------------------TODOS OS ALUNOS");
		System.out.println("RESULTADO:-----------------------------------");
		buscaPorTodos().forEach(cada -> System.out.println(cada));
		System.out.println("---------------------------------------------");
	}

}
