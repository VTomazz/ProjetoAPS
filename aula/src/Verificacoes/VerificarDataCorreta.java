package Verificacoes;

import Exception.ValorDoAnoException;

public class VerificarDataCorreta {

	
	public boolean verificar(String anoRecebe) throws ValorDoAnoException {
		Integer ano = Integer.parseInt(anoRecebe);
		if (ano >= 1900 && ano <= 2100) {
			return true;
		} else {
		  throw new ValorDoAnoException();
		}

	}

}
