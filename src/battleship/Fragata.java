package battleship;

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
