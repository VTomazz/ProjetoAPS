package Verificacoes;

import Exception.VerificarSeDoubleException;

public class VerificarSeDouble {
	
	public boolean verificar(String valor) throws VerificarSeDoubleException,NumberFormatException {
		double parseDouble = -0.1;
		try {
			parseDouble = Double.parseDouble(valor);	
		}catch (NumberFormatException e) {
		}
		
		
			
		if (parseDouble >= 0.0 && parseDouble <= 10.0) {
			return true;
		} else {
		    throw new VerificarSeDoubleException();
		}

	}

}
