package battleship;

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
