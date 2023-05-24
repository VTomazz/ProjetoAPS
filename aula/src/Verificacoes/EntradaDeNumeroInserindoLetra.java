package Verificacoes;

import Exception.EntradaDeNumeroInserindoLetraException;

public class EntradaDeNumeroInserindoLetra {


	public boolean verificar(String entrada) throws EntradaDeNumeroInserindoLetraException {
		if (entrada.matches("[0-9]+")) {
			return true;
		} else {

			throw new EntradaDeNumeroInserindoLetraException();

		}
	}
}
