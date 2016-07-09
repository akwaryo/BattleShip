package battleship;

public class Destroyer implements Navio {
	
	private int qtdDeNavios = 1;
	private int tamanhoNavio = 5;
	private String nomeNavio = "Destroyer";
	
	@Override
	public int getQtdDeNavios() {
		return qtdDeNavios;
	}
	@Override
	public int getTamanhoNavio() {
		return tamanhoNavio;
	}
	@Override
	public String getNomeNavio(){
		return nomeNavio;
	}
}
