package aula.cadastro;

import java.util.List;

import Terminal.CONTROLEGERAL;

public class Curso {

	private Integer id;
	private String nome;

	private NivelGraduacao nivel;
	private Integer ano;

	public Curso() {
	}


	public Curso(String nome2, NivelGraduacao nivelGraduacao, String ano2) {
		this.id = IdGeradorCurso();
		this.nome = nome2;
		this.ano = Integer.parseInt(ano2);
		this.nivel = nivelGraduacao;

	}

	private static int IdGeradorCurso() {

		List<Curso> list = CONTROLEGERAL.transformaMapEmListCurso();
		int id = 0;
		for (int i = 0; i <= list.size(); i++) {
			if (!CONTROLEGERAL.MAP_PRINCIPAL_CURSO.containsKey(i)) {//ELE BUSCA O PRIMEIRO ID DISPONIVEL FAZENDO A VARREDURA DE 1 EM 1
				id = i;
				break;
			}
		}
		return id;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public NivelGraduacao getNivel() {
		return nivel;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "[ID= " + id + ", NOME= " + nome + ", Nivel= " + nivel + ", Ano= "
				+ ano + "]";
	}

}
