package aula.cadastro;

import java.time.LocalDate;

import Fabricas.FabricaDeAluno;
import Fabricas.FabricaDeCurso;
import Terminal.CONTROLEGERAL;

public class CadastroCursoAluno {

	private Integer id;
	private Integer ano = LocalDate.now().getYear();
	private Rendimento rendimento;
	private Aluno aluno;
	private Curso curso;

	public CadastroCursoAluno(Curso curso) {//CONTRUTOR DE SAIDA - GRAVACAO CSV - UTILIZACAO DOS MAPS ENQUANTO UTILIZA
		this.id = IdGeradorCadastroCursoAluno();
		this.curso = curso;
		this.rendimento = new Rendimento(curso.getNivel());
	}

	public CadastroCursoAluno(String id2, String np1, String np2, String exame, String reposicao, String media,//COSTRUTOR DE ENTRADA - LEITURA DO CSV
			String idCurso, String idCliente, String nivel) {
		this.id = Integer.parseInt(id2);
		this.rendimento = new Rendimento(NivelGraduacao.valueOf(nivel));
		this.rendimento.setNp1(Double.parseDouble(np1));
		this.rendimento.setNp2(Double.parseDouble(np2));
		this.rendimento.setExame(Double.parseDouble(exame));
		this.rendimento.setReposicao(Double.parseDouble(reposicao));
		this.rendimento.setMedia(Double.parseDouble(media));
		this.curso = new FabricaDeCurso().buscarPorId(idCurso);
		this.aluno = new FabricaDeAluno().buscarPorId(idCliente);
		this.rendimento.setNivel(NivelGraduacao.valueOf(nivel));
	}

	private static int IdGeradorCadastroCursoAluno() {
		int id = 0;
		for (int i = 0; i <= CONTROLEGERAL.transformaMapEmListCadastroCursoAluno().size(); i++) {
			if (!CONTROLEGERAL.MAP_PRINCIPAL_CADASTRAR_CURSO_NO_ALUNO.containsKey(i)) {// ELE BUSCA O PRIMEIRO ID
																						// DISPONIVEL FAZENDO A
																						// VARREDURA DE 1 EM 1
				id = i;
				break;
			}
		}
		return id;

	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Rendimento getRendimento() {
		return rendimento;
	}

	@Override
	public String toString() {
		return "[ID= " + id + ", Prova1= " + rendimento.getNp1() + ", Prova2= " + rendimento.getNp2() + ", Reposicao= "
				+ rendimento.getReposicao() + ", Exame= " + rendimento.getExame() + ", Media= " + rendimento.getMedia()
				+ ", Resultado= " + rendimento.getResultado() + "\n-- Aluno= " + aluno.getNome() + ", Curso= "
				+ curso.getNome() + ", Cadastro= " + ano + "]";
	}

}
