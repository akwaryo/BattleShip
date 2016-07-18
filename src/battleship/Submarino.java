package battleship;
/**
 * Classe que implementa a embarcação do tipo Submarino.
 * <p> O submarino ocupa apenas 1 bloco e existem 5 no tabuleiro.
 * 
 * <p> Apenas os métodos Getters são implementados, já que as variáveis são definitivas.
 * 
 * @author Rodrigo Lima
 * @see Navio
 */

public class Submarino implements Navio{
	
	private int qtdDeNavios = 5;
	private int tamanhoNavio = 1;	
	private String nomeNavio = "Submarino";
	
	@Override
	public int getTamanhoNavio() {
		return tamanhoNavio;
	}
	@Override
	public int getQtdDeNavios() {
		return qtdDeNavios;
	}
	@Override
	public String getNomeNavio(){
		return nomeNavio;
	}
}
