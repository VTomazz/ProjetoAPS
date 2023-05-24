package Terminal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import GeradorCSV.AlunoCSV;
import GeradorCSV.CadastroCursoAlunoCSV;
import GeradorCSV.CursoCSV;
import aula.cadastro.Aluno;
import aula.cadastro.CadastroCursoAluno;
import aula.cadastro.Curso;

public class CONTROLEGERAL {
	
	
	public static Map<Integer, Aluno> MAP_PRINCIPAL_ALUNO = new HashMap<>();
	public static Map<Integer, Curso> MAP_PRINCIPAL_CURSO = new HashMap<>();
	public static Map<Integer, CadastroCursoAluno> MAP_PRINCIPAL_CADASTRAR_CURSO_NO_ALUNO = new HashMap<>();

	public static void leituraDeMaps() {
		new AlunoCSV().leitura();//gera Aluno para CadastroCursoAlunoCSV e CursoCSV inicializar
		new CursoCSV().leitura();
		new CadastroCursoAlunoCSV().leitura();
		new AlunoCSV().leitura();//depois ele abre novamente para usar os Map's gerados pelo CadastroCursoAlunoCSV para atualizar cada aluno com seus cursos
	}
	
	
	

	
	public static List<Aluno> transformaMapEmListAluno() {
		List<Aluno> ela = new ArrayList<>();
		for (Entry<Integer, Aluno> cada : MAP_PRINCIPAL_ALUNO.entrySet()) {
			ela.add(cada.getValue());
		}
		return ela;
	}
	public static List<Curso> transformaMapEmListCurso() {
		List<Curso> ela = new ArrayList<>();
		for (Entry<Integer, Curso> cada : MAP_PRINCIPAL_CURSO.entrySet()) {
			ela.add(cada.getValue());
		}
		return ela;
	}
	public static List<CadastroCursoAluno> transformaMapEmListCadastroCursoAluno() {
		List<CadastroCursoAluno> ela = new ArrayList<>();
		for (Entry<Integer, CadastroCursoAluno> cada : MAP_PRINCIPAL_CADASTRAR_CURSO_NO_ALUNO.entrySet()) {
			ela.add(cada.getValue());
		}
		return ela;
	}

	public boolean procurarNomeLista(Aluno aluno) {
		List<Aluno> list = transformaMapEmListAluno();
		
		for (Aluno cada : list) {
			if (cada.getNome().compareTo(aluno.getNome()) == 0) {
				return true;
			}
		}

		return false;
	}


}
