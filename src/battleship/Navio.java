package battleship;
/**
 * Interface que fornece os tipos de navios disponíveis no jogo.
 * 
 * @author Rodrigo Lima
 * @see Fragata
 * @see Destroyer
 * @see Submarino
 */

public interface Navio {
	
	public int getTamanhoNavio();

	public int getQtdDeNavios();
	
	public String getNomeNavio();
	
}
