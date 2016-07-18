package battleship;
/**
 * Classe que implementa as características do jogador da aplicação.
 * <p> Implementa a interface Seriarizable que permite que o objeto jogador seja persistido em arquivo.
 * Implementa a interface Comparable que permite que uma lista com objetos do tipo jogador seja ordenada
 * pelos valores de suas variáveis.
 * @param nome Nome do jogador ativo na aplicação.
 * @param pontuacao Pontuação do jogador no jogo.
 * @author Rodrigo Lima
 */

import java.io.Serializable;

public class Jogador implements Serializable, Comparable<Jogador> {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private int pontuacao;
	
	/**
	 * Método que retorna o nome do jogador.
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Método que seta o nome do jogador.
	 * @param nome Recebe o nome informado na Tela Inicial.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Método que retorna a pontuação do jogador.
	 * @return int pontuacao
	 */
	public int getPontuacao() {
		return pontuacao;
	}
	/**
	 * Método que seta a pontuação do jogador.
	 * @param pontuacao Recebe a pontuação alcançada no jogo.
	 */
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	/**
	 * Método que monta uma String com os atributos do jogador e retorna a String anterior com a nova String.
	 * <p> O mesmo jogador pode fazer diversos jogos e com diversas pontuações distintas, a classe StringBuilder
	 * permite que a criação de fluxos de String com o mesmo nome e com as pontuações diferentes, uma 
	 * concatenada à outra para gravação no arquivo com as pontuações corretas.
	 */
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("Nome: " + this.nome + " Pontuacao: " + this.pontuacao);
		return str.toString();
	}
	/**
	 * Método que ordena a lista com objetos do tipo Jogador de acordo com sua pontuação.
	 * <p> A interface Comparable permite a ordenação do objeto jogador, o método compareTo implementa 
	 * essa ordenação. O inteiro menos o valor a ser ordenado, retorna a lista de maneira descendente,
	 * para uma ordem ascendente a implementação deve ser valor menos o inteiro compararPontos.
	 */
	@Override
	public int compareTo(Jogador jog) {
		int compararPontos = ((Jogador) jog).getPontuacao();		
		return compararPontos - this.pontuacao;
	}
}
