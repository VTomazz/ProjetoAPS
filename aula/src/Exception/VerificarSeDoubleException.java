package Exception;

public class VerificarSeDoubleException extends TodasExcecoes {

	private static final long serialVersionUID = 74905380240518455L;

	public VerificarSeDoubleException() {
		//super();
		System.out.println("O valor esta inválido. Precisa ser de 0.0 a 10.0, utilize .(ponto) em vez de ,(virgula)");
	}
	
	 @Override
	    public void printStackTrace() {
	        // Deixa o método vazio para evitar a impressão da stack trace
	    }

}
