package aula.cadastro;

import java.util.ArrayList;
import java.util.List;

import Terminal.CONTROLEGERAL;

public class Aluno {


	private int id;
	private String nome;
	private List<CadastroCursoAluno> cursos = new ArrayList<CadastroCursoAluno>();

	public Aluno() {
	}

	public Aluno(String nome) {
		this.id = IdGeradorAluno();
		this.nome = nome;
	}

	public Aluno(String id2, String nome2) {
		this.id = Integer.parseInt(id2);
		this.nome = nome2;
		List<CadastroCursoAluno> selecionados = new ArrayList<>();
		
		List<CadastroCursoAluno> list = CONTROLEGERAL.transformaMapEmListCadastroCursoAluno();
		list.forEach(cada -> {
			if (String.valueOf(cada.getAluno().getId()).equals(id2)) {
				selecionados.add(cada);
			}
		});
		this.cursos = selecionados;
	}

	public void adicionarCurso(CadastroCursoAluno cadastro) {
		cadastro.setAluno(this);// ELE PEGA O ALUNO DE DENTRO DO CADASTROCURSOALUNO E SETA ELE MESMO LA DENTRO
		this.cursos.add(cadastro);// AQUI ELE ADICIONA O CURSO DENTRO DA LISTA QUE O ALUNO POSSUI COM SEUS CURSOS

	}
	


	public void removeCurso(CadastroCursoAluno cadastro, String id) {// ELE FAZ UMA VARREDURA POR TODOS OS CURSO QUE O ALUNO POSSUI E REMOVE O ID ESCOLHIDO

		this.cursos.forEach(cada -> {
			if (cada.getCurso().getId() == Integer.parseInt(id) - 1) {
				this.cursos.remove(cada);
			}
		});

	}
	
	private static int IdGeradorAluno() {
		
		int id = 0;
		for (int i = 0; i <= CONTROLEGERAL.MAP_PRINCIPAL_ALUNO.size(); i++) {
			if (!CONTROLEGERAL.MAP_PRINCIPAL_ALUNO.containsKey(i)) {//ELE BUSCA O PRIMEIRO ID DISPONIVEL FAZENDO A VARREDURA DE 1 EM 1
				id = i;
				break;
			}
		}
		return id;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CadastroCursoAluno> getCursos() {
		return cursos;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + " | " + "NOME: " + this.nome + " | " + "CURSOS: " + cursos.size();
	}
}
