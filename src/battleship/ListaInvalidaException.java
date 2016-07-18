package battleship;

public class ListaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ListaInvalidaException(String mensagem){
		super(mensagem);
	}

}
