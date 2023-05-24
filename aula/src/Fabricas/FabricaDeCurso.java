package Fabricas;

import java.util.List;

import Terminal.CONTROLEGERAL;
import aula.cadastro.Curso;
import aula.cadastro.NivelGraduacao;

public class FabricaDeCurso {
	
	
	public FabricaDeCurso() {
		
	}
	
	public void gerarNovo(String nome,NivelGraduacao nivel,String ano){
		Curso curso = new Curso(nome,nivel,ano);
		CONTROLEGERAL.MAP_PRINCIPAL_CURSO.put(curso.getId(), curso);
	}
	public Curso buscarPorId(String id) {
		return CONTROLEGERAL.MAP_PRINCIPAL_CURSO.get(Integer.parseInt(id));
	}

	public List<Curso> buscaPorTodos(){
		return CONTROLEGERAL.transformaMapEmListCurso();
	}

	public void resultadoGeral() {
		System.out.println();
		System.out.println("------------------------------TODOS OS CURSOS");
		System.out.println("RESULTADO:-----------------------------------");
		buscaPorTodos().forEach(cada -> System.out.println(cada));
		System.out.println("---------------------------------------------");
		System.out.println();
		
	}
}


