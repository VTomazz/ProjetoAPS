package Exception;

public class VerificaSeSimOuNaoException extends TodasExcecoes {

	private static final long serialVersionUID = 5595210148653828013L;

	public VerificaSeSimOuNaoException() {
		//super();
		System.out.println("Não esta digitando 'S' ou 'N', tente novamente...");
	}

	 @Override
	    public void printStackTrace() {
	        // Deixa o método vazio para evitar a impressão da stack trace
	    }
}
