package aula.cadastro;

public class Rendimento {

	private Double np1 = 0.0;
	private Double np2 = 0.0;
	private Double reposicao = 0.0;
	private Double exame = 0.0;
	private NivelGraduacao nivel;
	private Double media = 0.0;
	private String resultado = new String();

	public Rendimento() {
	}

	public Rendimento(NivelGraduacao nivel) {
		this.nivel = nivel;
	}

	public void atualizaRendimentoTodos() {
		regra1();
		regra2();
	}

	private void regra1() {
		if (reposicao > np1 && reposicao > np2) {
			if (np1 < np2) {
				np1 = reposicao;//ELE ACHA O MENOR VALOR ENTRE NP1 E NP2
			} else {
				np2 = reposicao;
			}
		}
	}

	private void regra2() {
		if (mediaInicial() > nivel.getValor()) {
			resultado = "Aprovado na media inicial";
			this.media = mediaInicial();
		} else {
			if (mediaFinal() >= 5.0) {
				resultado = "Aprovado na média final";
				this.media = mediaFinal();
			} else {
				resultado = "Reprovado na media final";
				this.media = mediaFinal();
			}
		}

	}
	
	public void resultadoGeral() {
		System.out.println("---------------------------------------------");
		System.out.println("RESULTADO:-----------------------------------");
		atualizaRendimentoTodos();
		System.out.println("---------------------------------------------");
		System.out.println();

	}

	private double mediaInicial() {
		return (np1 + np2) / 2;

	}

	private double mediaFinal() {
		return (mediaInicial() + exame);

	}

	public Double getNp1() {
		return np1;
	}

	public void setNp1(Double np1) {
		this.np1 = np1;
	}

	public Double getNp2() {
		return np2;
	}

	public void setNp2(Double np2) {
		this.np2 = np2;
	}

	public Double getReposicao() {
		return reposicao;
	}

	public void setReposicao(Double reposicao) {
		this.reposicao = reposicao;
	}

	public Double getExame() {
		return exame;
	}

	public void setExame(Double exame) {
		this.exame = exame;
	}
	
	public Double getMedia() {
		return media;
	}
	
	public void setMedia(Double media) {
		this.media = media;
	}
	
	public String getResultado() {
		return resultado;
	}

	@Override
	public String toString() {
		return "[PROVA 1= " + np1 + ", PROVA 2= " + np2 + ", REPOSICAO= " + reposicao + ", EXAME= " + exame + ", NIVEL="
				+ nivel + ", MEDIA= " + media + ", RESULTADO= " + resultado+ "]";
	}
	
	
	public NivelGraduacao getNivel() {
		return nivel;
	}
	
	public void setNivel(NivelGraduacao nivel) {
		this.nivel = nivel;
	}

}
