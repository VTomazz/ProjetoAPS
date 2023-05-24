package Exception;

public class ValorDoAnoException extends TodasExcecoes {


	private static final long serialVersionUID = -4202221060206850457L;

	public ValorDoAnoException() {
		//super();
		System.out.println("O ano esta inválido.");
	}
	
	 @Override
	    public void printStackTrace() {
	        // Deixa o método vazio para evitar a impressão da stack trace
	    }

}
