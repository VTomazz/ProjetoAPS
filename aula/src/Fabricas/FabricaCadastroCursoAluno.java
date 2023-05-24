package Fabricas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Terminal.CONTROLEGERAL;
import aula.cadastro.Aluno;
import aula.cadastro.CadastroCursoAluno;
import aula.cadastro.Curso;

public class FabricaCadastroCursoAluno {

	public FabricaCadastroCursoAluno() {
	}

	public void gerar(Aluno aluno, Curso curso) {
		CadastroCursoAluno cca = new CadastroCursoAluno(curso);
		aluno.adicionarCurso(cca);
		CONTROLEGERAL.MAP_PRINCIPAL_CADASTRAR_CURSO_NO_ALUNO.put(cca.getId(), cca);
		
	}


	public CadastroCursoAluno buscaPorId(Integer id) {
		return CONTROLEGERAL.MAP_PRINCIPAL_CADASTRAR_CURSO_NO_ALUNO.get(id);
	}

	public List<CadastroCursoAluno> buscaPorTodos() {
		return CONTROLEGERAL
				.transformaMapEmListCadastroCursoAluno();
	}

	public Map<Integer,CadastroCursoAluno> buscaTodosPorId(String id) {
		List<CadastroCursoAluno> list = CONTROLEGERAL.transformaMapEmListCadastroCursoAluno();
		Map<Integer,CadastroCursoAluno> nova = new HashMap<Integer,CadastroCursoAluno>();
		for (CadastroCursoAluno cada : list) {
			if (String.valueOf(cada.getAluno().getId()).equals(id)) {
				nova.put(cada.getId(),cada);

			}
		}
		List<CadastroCursoAluno> mapList = new ArrayList<>(nova.values());
		mapList.forEach(c -> System.out.println(c));
		return nova;

	}
	
	public void resultadoGeral() {
		System.out.println("---------------------------------------------");
		System.out.println("RESULTADO:-----------------------------------");
		buscaPorTodos().forEach(cada -> System.out.println(cada));
		System.out.println("---------------------------------------------");

	}

}
