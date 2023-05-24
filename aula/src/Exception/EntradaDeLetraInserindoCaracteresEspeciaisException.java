package Exception;

public class EntradaDeLetraInserindoCaracteresEspeciaisException extends TodasExcecoes {

	private static final long serialVersionUID = -5311320161493753138L;

	public EntradaDeLetraInserindoCaracteresEspeciaisException() {
		//super();
		System.out.println("A entrada contém caracteres inválidos.");
	}
	
	 @Override
	    public void printStackTrace() {
	        // Deixa o método vazio para evitar a impressão da stack trace
	    }

}
