package battleship;
/**
 * Classe que implementa a embarcação do tipo Fragata.
 * <p> A Fragata ocupa 3 blocos e existem 3 no Tabuleiro.
 * 
 * <p> Apenas os métodos Getters são implementados, já que as variáveis são definitivas.
 * 
 * @author Rodrigo Lima
 * @see Navio
 */
public class Fragata implements Navio {
	
	private int qtdDeNavios = 3;
	private int tamanhoNavio = 3;
	private String nomeNavio = "Fragata";
	
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
