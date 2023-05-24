package Exception;

public class EntradaDeNumeroInserindoLetraException extends TodasExcecoes  {

	private static final long serialVersionUID = -5815132863690271691L;

	public EntradaDeNumeroInserindoLetraException() {
		//super();
		System.out.println("Voce esta tentando colocar um texto aonde pode apenas NUMEROS");
	}
	
	 @Override
	    public void printStackTrace() {
	        // Deixa o método vazio para evitar a impressão da stack trace
	    }

}
