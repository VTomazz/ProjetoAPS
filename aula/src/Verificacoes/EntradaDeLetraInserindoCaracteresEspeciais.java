package Verificacoes;

import Exception.EntradaDeNumeroInserindoLetraException;

public class EntradaDeLetraInserindoCaracteresEspeciais{

	public boolean verificar(String entrada) throws EntradaDeNumeroInserindoLetraException {
		if (entrada.matches("^[a-zA-Z0-9 ]+$")) {
			return true;
		} else {
			throw new EntradaDeNumeroInserindoLetraException();
		}
	}
	
	

}
