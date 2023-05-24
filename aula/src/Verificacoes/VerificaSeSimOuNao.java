package Verificacoes;

import Exception.VerificaSeSimOuNaoException;

public class VerificaSeSimOuNao {

	public boolean verificar(String entrada) throws VerificaSeSimOuNaoException{
		if (entrada.equalsIgnoreCase("s") || entrada.equalsIgnoreCase("n")) {
			return true;
		} else {
			throw new VerificaSeSimOuNaoException();
		}

	}

}
