package aula.cadastro;

public enum NivelGraduacao {

	GRADUACAO(7.0), POS_GRADUACAO(5.0);

	private final double valor;

	NivelGraduacao(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
}