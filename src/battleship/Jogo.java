package battleship;
/**
 * Classe que implementa métodos para distribuição das embarcações e que inicia o Jogo.
 * @see Navio
 * @see Tabuleiro
 * @author Rodrigo Lima
 */

import java.util.ArrayList;
import java.util.Random;

public class Jogo {
	
	private Random generate = new Random();
	
	/**
	 * Método que distribui as embarcações no tabuleiro.
	 * <p> A posição de cada navio no tabuleiro é gerada randomicamente e armazenada nas variáveis 
	 * linha e coluna.
	 * <p> Uma lista com os navios é criada e todas as posições do tabuleiro são preenchidas com 0 (água).
	 * <p> A orientação dos navios é gerada randomicamente e o método cabeNavio verifica se existe espaço,
	 * se existir os navios são distribuídos, se não, novas posições são geradas.
	 * @param vetor Vetor criado pela classe Tabuleiro que receberá os Navios ou Água.
	 */
	public void iniciaJogo(int[][] vetor){		
		
		// Cria a posição do navio no tabuleiro
		int linha = generate.nextInt(10); // Linha
		int coluna = generate.nextInt(10); // Coluna
		boolean cabe = false;
		
		// Criando ArrayList com navios
		ArrayList<Navio> navios = new ArrayList<>();
		
		// Adicionando navios na Lista
		navios.add(new Destroyer());
		navios.add(new Fragata());
		navios.add(new Submarino());
		
		// Preenche o vetor com Zeros (0)
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				vetor[i][j] = 0;
			}
		}
		
		for(int cont = 0; cont < navios.size(); cont++){
			int contador = 0;
			while(navios.get(cont).getQtdDeNavios() > contador) {				
				
				// Cria a orientação do Navio. 0 Vertical. 1 Horizontal
				int orientacao = generate.nextInt(2);
				
				// Verifica se o navio cabe na posição do tabuleiro criada
				cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
				
				// Se o Navio não couber, gera outra posição
				if(cabe == false){
					while(cabe == false){
						linha = generate.nextInt(10); // Linha
						coluna = generate.nextInt(10); // Coluna
						cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
					}
				}
				
				// Se o Navio couber, distribui os navios 
				if (orientacao == 0){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						linha++;
					}
				}
				
				else if (orientacao == 1){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						coluna++;
					}
				}
				contador++;
			}
		}
	}
	/**
	 * Método que verifica se o navio pode ser distribuído na posição gerada randomicamente.
	 * <p> O tabuleiro é distribuído como uma matriz, com linhas e colunas, os navios maiores precisam
	 * estar distribuídos dentro dos limites do tabuleiro e em posições vazias, onde não existam navios
	 * já distribuídos.
	 * @return Retorna true se o navio couber na posição, se não, retorna false.
	 * @param linha Linha gerada randomicamente.
	 * @param coluna Coluna gerada randomicamente.
	 * @param orientacao Orientação do navio.
	 * @param tamanho Tamanho de blocos que o navio ocupa.
	 * @param vetor Vetor com as posições que podem ou não conter os navios.
	 * @return Retorna true se o navio couber na posição, se não retorna false.
	 */
	public boolean cabeNavio(int linha, int coluna, int orientacao, int tamanho, int vetor[][]){
		// Se a orientação for Vertical, trava a coluna e incrementa a linha
		if (orientacao == 0){
			if (linha > (9 - tamanho)){
				return false;
			}
			for (int row = 0; row < tamanho; row++){
				if (vetor[linha][coluna] == 0){
					linha++;
				}
				else {
					return false;
				}
			}
			return true;
		}
		
		// Se a orientação for Horizontal, trava a linha e incrementa a coluna
		if (orientacao == 1){
			if (coluna > (9 - tamanho)){
				return false;
			}
			for (int col = 0; col < tamanho; col++){
				if (vetor[linha][coluna] == 0){
					coluna++;
				}
				else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
